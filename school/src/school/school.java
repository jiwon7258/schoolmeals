package school;
import java.util.List;
import java.util.Locale;

import org.hyunjun.school.School;
import org.hyunjun.school.SchoolException;
import org.hyunjun.school.SchoolMenu;
import org.hyunjun.school.SchoolSchedule;

import java.awt.Robot;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
public class school {

	public static void main(String[] args) throws Throwable {
		
		School api = new School(School.Type.HIGH, School.Region.DAEJEON, "G100000214");
		
		
		while(true) {
		try {
			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
			Date currentTime = new Date ();
			Calendar cal = Calendar.getInstance();
			int year = cal.get ( cal.YEAR );
			int month = cal.get ( cal.MONTH ) + 1 ;
			int date = cal.get ( cal.DATE ) ;

			date = date -1;
			int date1 = date + 1 ;
			
		    List<SchoolMenu> menu = api.getMonthlyMenu(year, month);

//		    // 2017년 4월 22일 저녁 급식 식단표
//		    System.out.println(year + "년 "+ month + "월" + date + "일의 급식입니다");
//		    System.out.println("\n[점심]");
//		    System.out.println(menu.get(date).lunch);
//		    System.out.println("\n[저녁]");
//		    System.out.println(menu.get(date).dinner);



		    String fileName = "meal.txt" ;
        
		    String txt = year + "년 "+ month + "월" + date1 + "일의 급식입니다" + "\r\n[점심]\r\n" + menu.get(date).lunch + "\r\n[저녁]\r\n" + menu.get(date).dinner ;
		    System.out.print(txt);
                         
            // BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName));
             
            // 파일안에 문자열 쓰기
            fw.write(txt);
            fw.flush();
 
            // 객체 닫기
            fw.close();
            Thread.sleep(1000 * 60 * 60);
	            
			}
		
		 catch (SchoolException e) {
			    e.printStackTrace();}
		
		catch (IOException e) {
			throw e;}
		}
		
	}
}
