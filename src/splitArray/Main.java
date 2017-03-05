package splitArray;


public class Main {
	public static void main(String[] args){
		//�����˼����������
		int[] nums={2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7};//���ؽ��ӦΪtrue
		int[] nums1={10, 2, 11, 13, 1, 1, 1, 1, 1};//���ؽ��ӦΪfalse
		int[] nums2={1,1,1,1,7,1,3,4,1,2,1,5,2,2};//���ؽ��ӦΪtrue
		int[] nums3={1,1,1,1,10,1,3,1,1,2,1,5,2,2};//���ؽ��ӦΪtrue
		int[] nums4={2,2,5,1,2,1,1,3,1,10,1,1,1,1};//nums3�ĵ��򣬷��ؽ��ӦΪtrue
		
		//������ڣ�����Ϊ��������
		boolean flag=isFourPart(nums4);
		//������
		if(flag){
			System.out.println("���Ա��ֳ��ĵȷ�");
		}else{
			System.out.println("�����Ա��ֳ��ĵȷ�");
		}
				
	}

	/**
	 * �ú������ж������Ƿ��ֳܷ��ĵȷݵ����
	 * ����˼·�ǣ�
	 * 1.���ҵ�һ���͵������ָ�����λ�ã�������λ�ÿ����ж��������Ҫע�⣩
	 * 2.�����͵õ���һ����׼���Լ���һ���͵��ĸ����������������ж��������
	 * 3.�������ҵڶ������飬�÷���ĺ�Ҫ������ڻ�׼��������
	 * 4.�������ĺʹ��ڻ�׼���Ļ�˵����һ���͵������ָ�����λ�ò��ԣ�ȡ��һ����������жϣ��ص�3
	 * 5.�������ĺ͵��ڻ�׼���Ļ��͵õ��ڶ����ָ�����λ�ú͵ڶ�����������
	 * 6.�õ��ڶ����ָ�����λ�ú�Ҫ���ڶ����ָ�����������ָ���֮��ĵ���������ĺ��Ƿ���ڻ�׼��
	 * 7.��������ڵĻ�����˵����һ���͵������ָ�����λ�ò��ԣ�ȡ��һ����������жϣ��ص�3
	 * @param nums Ҫ�жϵ�����
	 * @return �Ƿ��ֳܷ��ĵȷ�
	 */
	private static boolean isFourPart(int[] nums) {
		Boolean flag=false;
		int splitPositionNums=50;//��ָ������ܳ��ֵ������������һ����������ж��ַָ�������������һ�㣩
		int[] split1=new int[splitPositionNums];//��ŵ��ǵ�һ���ָ������ܵ�����λ��
		int[] split3=new int[splitPositionNums];//��ŵ��ǵ������ָ������ܵ�����λ��
		int[] sum=new int[splitPositionNums];//��ŵ��Ƿ���ĺͿ��ܵ���������������������໥��Ӧ��
		
		//���ú����ҵ���һ���͵������ָ�����λ�õ��������
		findPositionOfFirstAndThird(nums,split1,split3,sum);
		
		//��������������������������ѭ����ʱ�临�ӶȻ����O��n��
		//���Է���һ�£�������һ���õ���split1�ĸ��������޵ģ���ʹ�����ж������ҲԶԶ����n
		//���Կ��Կ��ɳ���
		for(int i=0;i<split1.length;i++){
			System.out.println("��"+i+"�Էָ�����λ��"+split1[i]+" "+split3[i]);
			int start=split1[i]+1;
			int end=split3[i]-1;
			
			//���ú����ҵڶ����ָ���
			int split2=findPositionOfSecond(nums,split1[i],split3[i],sum[i],start,end);
			if(split2==0){ //���split2Ϊ0�Ļ�˵�������ĵȷ�
				continue;
			}
			//���ú������ڶ����ָ����͵������ָ���֮���Ԫ�صĺ��Ƿ����sum
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
		//���forѭ���Ǽ��ڶ����ָ����͵������ָ���֮���Ԫ�صĺ��Ƿ����fenzu1
		for(int i=split2+1;i<=end;i++){
			fenzu3+=nums[i];
			if(fenzu3==sum&&i==end){
				return true;
			}
			
		}
		return null;
	}

	private static int findPositionOfSecond(int[] nums, int split1, int split3, int sum,int start,int end) {
		
		int fenzu2=0;//��ʼ���ڶ�������ĺ�
		int split2=0;//�ڶ����ָ���
		
		//���ѭ�����������ҵڶ����ָ���
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
		int fenzu1=nums[0]; //��ʼ����һ������ĺ�
		int fenzu4=nums[len-1]; //��ʼ�����ĸ�����ĺ�
		int count=0; //�ۼƷָ������ܳ��ֵ�����
		
		//���forѭ�����������ҵ���һ���͵������ָ�����λ��
		for(int i=1,j=len-2;i<j;){
			if(fenzu1<fenzu4){
				fenzu1+=nums[i];
				i++;			
			}else if(fenzu1>fenzu4){
				fenzu4+=nums[j];
				j--;
			}else{
				split1[count]=i;//��һ���ָ���
				split3[count]=j;//�������ָ���
				sum[count]=fenzu1;//����ĺ�
				fenzu1+=nums[i];
				fenzu4+=nums[j];
				i++;
				j--;
				count++;
			}		
		}
		
	}

}
