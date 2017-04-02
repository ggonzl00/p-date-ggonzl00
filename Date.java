package fecha;

public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year){  //constructor
		this.day = day;
		this.month = month;
		this.year = year;
		/*if(day < 1 || day > 31){
			throw new DateException ("El dia " + day +" no valido.Valores posibles entre 1 y 31");
		}else{
			this.day = day;
		}
		if(month < 1 || month > 12){
			throw new DateException ("El mes " + month +" no valido.Valores posibles entre 1 y 12");
		}else{
			this.month = month;
		}*/
	}
	
	public Date (int year){  //genera aleatoriamente el dia y el mes 
		this.year = year;
		this.month =  (int) ((Math.random() * 12) + 1);
		this.day = (int) ((Math.random() * this.getNumberDaysMonth(this.month)) + 1);
	}
	
	public int getDay(){
		return day;
	}
	
	public void setDay(int valor){
		day = valor;
		
	}
	
	public int getMonth(){
		return month;
	}
	
	public void setMonth(int valor){
		month = valor;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(int valor){
		year = valor;
	}
	
	/*public boolean isSameYear(Date otraFecha ){
		if(year == otraFecha.getYear()){
			return true;
		}else{
			return false;
		}
	}*/
	
	public boolean isSameYear(Date otraFecha){
		return year == otraFecha.getYear();
	}
	
	public boolean isSameMonth (Date otraFecha){
		return month == otraFecha.getMonth();
	}
	
	public boolean isSameDay(Date otraFecha){
		return day == otraFecha.getDay();
	}
	/*public boolean isSame (Date otraFecha){
		if(isSameYear(otraFecha) && isSameMonth(otraFecha) && isSameDay(otraFecha)){
			return true;
		}else{
			return false;
		}
	}*/
	
	public boolean isSame(Date otraFecha){
		return isSameYear(otraFecha) && isSameMonth(otraFecha) && isSameDay(otraFecha);
	}
	
				/*--------------------------*/
	
	private String nameMonth(int month){ 
		String nombre = "Error, no existe";
		switch (month){
		case 1: nombre = "Enero";
			break;
		case 2: nombre = "Febrero";
			break;
		case 3: nombre = "Marzo";
			break;
		case 4: nombre = "Abril";
			break;
		case 5: nombre = "Mayo";
			break;
		case 6: nombre = "Junio";
			break;
		case 7: nombre = "Julio";
			break;
		case 8: nombre = "Agosto";
			break;
		case 9: nombre = "Septiembre";
			break;
		case 10: nombre = "Octubre";
			break;
		case 11: nombre = "Noviembre";
			break;
		case 12: nombre = "Diciembre";
			break;
		}
		return nombre;
	}
	
	public String nameMonth(){
		return this.nameMonth(this.month);
	}

	public boolean isDayValid(){
		if(this.day > this.getNumberDaysMonth(this.month) || this.day <= 0){
			return false;
		}else{
			return true;
		}
	}
	
	
	
	public String nameSeason(){
		String season = "Error, no existe";
		switch(month){
		case 1:
		case 2:
		case 3: season = "Invierno";
			break;
		case 4:
		case 5:
		case 6: season = "Primavera";
			break;
		case 7:
		case 8:
		case 9: season = "Verano";
			break;
		case 10:
		case 11:
		case 12: season = "Otoño";
			break;
		}
		return season;
	}
	
				/*--------------------------*/


	public String monthLeftUntilLastMonthOfYear(){
		StringBuilder cad= new StringBuilder();
		for(int i=this.month; i<=12; i++){
			cad.append(this.nameMonth(i));
			cad.append(" ");
		}
		return cad.toString();
	}
	
	public String allDatesUntilEndMonth(){
		StringBuilder cad= new StringBuilder();
		Date fecha;
		for(int i = this.day; i < this.getNumberDaysMonth(); i++){
			fecha = new Date (i, this.month, this.year);
			cad.append(fecha.toString());	
			cad.append(" ");
		}
		return cad.toString();
	}


	private int getNumberDaysMonth(int month){
		int numDay = 0;
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: numDay = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11: numDay = 30;
			break;
		case 2: numDay = 28;
			break;
		default : System.out.println("Error, esto no es un mes");
			break;
		}
		return numDay;
	}
	
	
	//Metodo auxiliar, es privado
	
	public int getNumberDaysMonth(){
		return this.getNumberDaysMonth(this.month);
	}

	public String monthsSameAmountDays(){
		StringBuilder cad= new StringBuilder();
		for(int i=1; i<=12; i++){
			if(this.getNumberDaysMonth(i) == this.getNumberDaysMonth()){
				cad.append(this.nameMonth(i));
				cad.append(" ");
			}
		}
		return cad.toString();
	}
	
	public int countDaySinceFirstDayYear(){
		int counter = this.day;
		for(int i=1; i<this.month; i++){
			counter = counter + getNumberDaysMonth(i);    //counter += getNumDaysMonth(i); 
			
		}
		//counter = counter + this.day;  se puede hacer cualquiera de las dos opciones
		return counter;
	}
	
				/*--------------------------*/
	
	public int getNumberAttempts(){
		int counter = 0;
		boolean end = false;
		Date randomDate;
		
		do{
			randomDate = new Date(this.year);  //como solo tiene el parametro year, usaria el constructor que tiene un solo parametro
			counter ++;
			if(this.equals(randomDate)){ 
				end = true;
			}
		} while(! end);
		return counter;
	}

	public String toString() {
		String dia="";
		if (this.day>9) {
			dia=""+this.day;
		} else {
			dia="0"+this.day;
		}
		
		String mes="";
		if (this.month>9) {
			mes=""+this.month;
		} else {
			mes="0"+this.month;
		}
		
		return dia + "/" + mes + "/" + this.year;
		
	}
	
	public boolean equals(Date otherDate) {
		boolean retorno = false;
		if(this.day == otherDate.getDay() && this.month == otherDate.getMonth()
				&& this.year == otherDate.getYear()){
			retorno = true;
		}
		return retorno;
	}
	
}

