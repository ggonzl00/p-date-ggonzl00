public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year){  //constructor
		this.day = day;
		this.month = month;
		this.year = year;
	}
	//ACABAR EL CONSTRUCTOR!!!!
	public Date (int year){  //genera aleatoriamente el day y el mes 
		/*this.year = year;
		this.month = // ramdon x(1-12)
		if(dependiendo del mes, que lo hago entre X dias){
		this.day = random
		}*/
	}
	
	public int getDay(){
		return day;
	}
	
	public void setDay(int valor){
		day = valor;
		//System.out.println(day);
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
	
	private String nameMonth(int month){  //POR QUE NO RECIBE NADA??
		String nombre = "Error no existe";
		switch (this.month){
		case 1: nombre = "Enero";
			//System.out.println(nombre);
			return nombre;
			//break;
		case 2: nombre = "Febrero";
			//System.out.println("Febrero");
			return nombre;
			//break;
		case 3: nombre = "Marzo";
			return nombre;
			//System.out.println("Marzo");
			//break;
		case 4: nombre = "Abril";
			return nombre;
			//System.out.println("Abril");
			//break;
		case 5: nombre = "Mayo";
			//System.out.println("Mayo");
			//break;
		case 6: nombre = "Junio";
			return nombre;
			//System.out.println("Junio");
			//break;
		case 7: nombre = "Julio";
			return nombre;
			//System.out.println("Julio");
			//break;
		case 8: nombre = "Agosto";
			return nombre;
			//System.out.println("Agosto");
			//break;
		case 9: nombre = "Septiembre";
			return nombre;
			//System.out.println("Septiembre");
			//break;
		case 10: nombre = "Octubre";
			return nombre;
			//System.out.println("Octubre");
			//break;
		case 11: nombre = "Noviembre";
			return nombre;
			//System.out.println("Noviembre");
			//break;
		case 12: nombre = "Diciembre";
			return nombre;
			 //System.out.println("Diciembre");
			//break;
		}
		return nombre;
	}
	
	public String nameMonth(){
		return this.nameMonth(this.month);
	}

	public boolean isDayValid(){
		int maxDay = 0;
		switch (this.month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: maxDay = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11: maxDay = 30;
			break;
		case 2: maxDay = 28;
			break;
		}
		if(this.day > maxDay || this.day <= 0){
			return false;
		}else{
			return true;
		}
	}
	
	
	
	public void nameSeason(){
		
		switch(this.month){
		case 1:
		case 2:
		case 3: System.out.println("Invierno");
			break;
		case 4:
		case 5:
		case 6: System.out.println("Primavera");
			break;
		case 7:
		case 8:
		case 9: System.out.println("Verano");
			break;
		case 10:
		case 11:
		case 12: System.out.println("Otoño");
			break;
		default: System.out.println("Error mes no existe");
		}
	}
	
				/*--------------------------*/


	private int getNumberDaysMonth(int month){
		int numDay = 0;
		switch(this.month){
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
		String cad= "Error";
		for(int i=1; i<=12; i++){
			if(this.getNumberDaysMonth(i) == this.getNumberDaysMonth()){
				return this.nameMonth(i);
			}
		}
		return cad;
	}
	
	public int countDaySinceFirstDayYear (){
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
		
		while(! end){
			randomDate = new Date(this.year);  //como solo tiene el parametro year, usaria el constructor que tiene un solo parametro
			counter ++;
			if(this.equals(randomDate)){
				end = true;
			}
		}
		return counter;
	}
	
}

