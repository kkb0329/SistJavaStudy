package day0224;

public class ArrayMaxMin_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] nums = {45,35,97,65,72,54,31,23,86,75};
		System.out.println("nums의 갯수: "+nums.length);
		
		int max=nums[0]; //첫 데이터를 무조건 최대값에 저장
		int min=nums[0];
		//두번쨰 데이터부터 끝까지 max랑 비교
		
		for (int i=1;i<nums.length;i++)
		{
			if(nums[i]>max)
				max=nums[i];	
			
			if(nums[i]<min)
				min=nums[i];
		}
		System.out.println("최대값: "+max);
        System.out.println("최소값: "+min);
	}

}
