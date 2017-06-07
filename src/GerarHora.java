import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class GerarHora implements Serializable{
		public String gerador(){
			
			String hora = "Hmmss";
			String hora1;
			java.util.Date agora = new java.util.Date();;
			SimpleDateFormat formata = new SimpleDateFormat(hora);
			formata = new SimpleDateFormat(hora);
			hora1 = formata.format(agora);
			
			return hora1;
		}
}
