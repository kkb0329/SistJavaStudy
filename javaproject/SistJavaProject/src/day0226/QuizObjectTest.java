package day0226;

public class QuizObjectTest {

	public static void main(String[] args) {
		/*
		 * 과정명: 쌍용 교육센터 자바교육 4강의장
		 * ============================
		 * 학생1정보
		 * 이름: 손흥민
		 * 나이: 29세
		 * 지역: 부산
		 * 취미: 헬스
		 * 
		 * 학생2정보
		 * 이름: 김연아
		 * 나이: 26세
		 * 지역: 서울
		 * 취미: 여행
		 * 
		 * */
		 QuizObject.processName="쌍용 교육센터 자바교육 4강의장";
         QuizObject ab1 = new QuizObject();
         QuizObject ab2 = new QuizObject();
         ab1.setStuname("손흥민");
         ab2.setStuname("김연아");
         ab1.setAge(29);
         ab2.setAge(26);
         
         
         
         System.out.println("과정명: "+QuizObject.processName);
         System.out.println("==========================");
         String city = ab1.getCity();
         System.out.println("이름: "+ab1.stuName);
         System.out.println("나이: "+ab1.age);
         
	}

}
