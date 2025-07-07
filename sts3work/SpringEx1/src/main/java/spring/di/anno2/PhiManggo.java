package spring.di.anno2;

import org.springframework.stereotype.Component;

@Component("pmgo")
public class PhiManggo implements Friut {

	@Override
	public void writeFriutName() {
		// TODO Auto-generated method stub

		System.out.println("ÇÊ¸®ÇÉ ¸Á°í");
	}

}
