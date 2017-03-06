package splitArray;

/**
 * 阿里在线编程题（后台方向的题），30分钟内，没写完，但是写了思路上去，后来又完整实现了一下
 * 证明当时的思路是正确的，能达到要求的O（n）
 * 
 * 题意大概是给一个整形数组，数组大小上限是100000，对这个数组进行四等分（去掉分割的三个数），每份的和要相等
 * 返回时如果可以满足上面的要求就返回true，如果不可以就返回false
 * 
 * 原题给的格式我不记得了（反正只要编程实现就行了是不~）
 * @author CLara1
 *
 */
public class Main {
	public static void main(String[] args){
		//定义了几组测试数据
		int[] nums={2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7};//返回结果应为true
		int[] nums1={10, 2, 11, 13, 1, 1, 1, 1, 1};//返回结果应为false
		int[] nums2={1,1,1,1,7,1,3,4,1,2,1,5,2,2};//返回结果应为true，这个例子有陷阱的，请仔细看
		int[] nums3={1,1,1,1,10,1,3,1,1,2,1,5,2,2};//返回结果应为true
		int[] nums4={2,2,5,1,2,1,1,3,1,10,1,1,1,1};//nums3的倒序，返回结果应为true
		
		//函数入口，参数为测试数据
		boolean flag=isFourPart(nums4);
		//输出结果
		if(flag){
			System.out.println("可以被分成四等份");
		}else{
			System.out.println("不可以被分成四等份");
		}
				
	}

	/**
	 * 该函数是判断数组是否能分成四等份的入口
	 * 基本思路是：
	 * 1.先找第一个和第三个分割数的位置（这两个位置可能有多种情况，要注意）
	 * 2.这样就得到了一个基准数以及第一个和第四个分组的情况（可能有多种情况）
	 * 3.接下来找第二个分组，该分组的和要满足等于基准数的条件
	 * 4.如果分组的和大于基准数的话说明第一个和第三个分割数的位置不对，取下一种情况继续判断，回到3
	 * 5.如果分组的和等于基准数的话就得到第二个分割数的位置和第二个分组的情况
	 * 6.得到第二个分割数的位置后还要检查第二个分割数与第三个分割数之间的第三个分组的和是否等于基准数
	 * 7.如果不等于的话还是说明第一个和第三个分割数的位置不对，取下一种情况继续判断，回到3
	 * @param nums 要判断的数组
	 * @return 是否能分成四等份
	 */
	private static boolean isFourPart(int[] nums) {
		Boolean flag=false;
		int splitPositionNums=50;//设分割数可能出现的情况的总数（一个数组可能有多种分割方案）（可以设大一点）
		int[] split1=new int[splitPositionNums];//存放的是第一个分割数可能的所有位置
		int[] split3=new int[splitPositionNums];//存放的是第三个分割数可能的所有位置
		int[] sum=new int[splitPositionNums];//存放的是分组的和可能的情况，以上三个数组是相互对应的
		
		//调用函数找到第一个和第三个分割数的位置的所有情况
		findPositionOfFirstAndThird(nums,split1,split3,sum);
		
		//看到这里或许你会问这里有两重循环(这个循环里面会调用函数，函数里面还有一重循环)，时间复杂度难道不会大于O（n）吗？
		//其实可以分析一下，我们上一步得到的split1的个数是有限的，即使可能有多种情况也远远不及n
		//而且我设定只要满足题目要求就可以返回true，所以可以看成常数C，复杂度为O（Cn），也就是O（n）
		for(int i=0;i<split1.length;i++){
			System.out.println("第"+i+"对分割数的位置"+split1[i]+" "+split3[i]);
			int start=split1[i]+1;
			int end=split3[i]-1;
			
			//调用函数找第二个分割数
			int split2=findPositionOfSecond(nums,split1[i],split3[i],sum[i],start,end);
			if(split2==0){ //如果split2为0的话说明不能四等分
				continue;
			}
			//调用函数检查第二个分割数和第三个分割数之间的元素的和是否等于sum
			flag=checkOut(nums,split2,sum[i],start,end);
			if(flag){
				flag=true;
				break;
			}
		}
		return flag;
	}

	private static Boolean checkOut(int[] nums,int split2,int sum,int start,int end) {
		int fenzu3=0;
		//这个for循环是检查第二个分割数和第三个分割数之间的元素的和是否等于fenzu1
		for(int i=split2+1;i<=end;i++){
			fenzu3+=nums[i];
			if(fenzu3==sum&&i==end){
				return true;
			}
			
		}
		return null;
	}

	private static int findPositionOfSecond(int[] nums, int split1, int split3, int sum,int start,int end) {
		
		int fenzu2=0;//初始化第二个分组的和
		int split2=0;//第二个分割数
		
		//这个循环的作用是找第二个分割数
		while(start<end){
			fenzu2+=nums[start];
			if(fenzu2==sum){
				split2=start+1;
				break;
			}
			start++;	
		}
		return split2;
	}

	private static void findPositionOfFirstAndThird(int[] nums,int[] split1, int[] split3,int[] sum) {
		int len=nums.length;
		int fenzu1=nums[0]; //初始化第一个分组的和
		int fenzu4=nums[len-1]; //初始化第四个分组的和
		int count=0; //累计分割数可能出现的数量
		
		//这个for循环的作用是找到第一个和第三个分割数的位置
		for(int i=1,j=len-2;i<j;){
			if(fenzu1<fenzu4){
				fenzu1+=nums[i];
				i++;			
			}else if(fenzu1>fenzu4){
				fenzu4+=nums[j];
				j--;
			}else{
				split1[count]=i;//第一个分割数
				split3[count]=j;//第三个分割数
				sum[count]=fenzu1;//分组的和
				fenzu1+=nums[i];
				fenzu4+=nums[j];
				i++;
				j--;
				count++;
			}		
		}
		
	}

}
