import javax.xml.datatype.DatatypeConfigurationException;
import java.util.ArrayList;

/**
 * Created by Jasper on 8-10-2015.
 */
public class DateSet {
    private ArrayList<Date> dateSet;

    public DateSet() {
        dateSet = new ArrayList<Date>();
    }
    public void add(Date date) {
        dateSet.add(date);
    }
    public boolean contains(Date date) {
        for (Date dt : dateSet) {
            if (dt.equals(date)) {
                return true;
            }
        }
        return false;
    }
    public DateSet intersection(DateSet comparedTo) {
        DateSet newSet = new DateSet();
        for(int i = 0; i < dateSet.size(); i++) {
            Date originalDate = dateSet.get(i);
            if (comparedTo.contains(originalDate)) {
                newSet.add(originalDate);
            }
        }
        return newSet;
    }
    public String toString() {
        String result = ("Dateset {\n");
        for(int i = 0; i < dateSet.size(); i++) {
            result += (dateSet.get(i).toString()) + "\n";
        }
        result += ("}");
        return result;
    }
    public static void main(String[] args) {
        Date date = new Date("08-10-2015");
        Date date2 = new Date("09-10-2015");
        Date date3 = new Date("10-10-2015");
        DateSet dateset = new DateSet();
        DateSet dateset2 = new DateSet();
        dateset.add(date);
        dateset.add(date2);
        dateset.add(date3);

        dateset2.add(date);
        dateset2.add(date2);

        System.out.println(dateset.intersection(dateset2).toString());
    }
}
