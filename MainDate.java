

public class MainDate{

	public static void main (String args []){

		Date today = new Date (28,03,2017);
		Date yesterday = new Date (27,12,2017);
		System.out.println(today.isSameYear(yesterday));
		System.out.println(today.isSame(yesterday));
		System.out.println(yesterday.nameSeason());
		System.out.println(today.monthsSameAmountDays()); //ESTOS TRES DAN MAL, SALE EL MISMO MES
		System.out.println(today.monthLeftUntilLastMonthOfYear());
		System.out.println(today.monthsSameAmountDays());
		System.out.println(today.countDaySinceFirstDayYear());
		System.out.println(today.getNumberDaysMonth());
		//System.out.println(today.getNumberAttempts());
	}
}
