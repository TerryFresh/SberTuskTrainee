import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//1.
//У нас есть справочник городов. Он представлен в текстовом виде и состоит из следующих полей:
//Порядковый номер записи справочника;
//Наименование города;
//Регион;
//Федеральный округ;
//Количество жителей;
//Дата основания или первое упоминание

//Необходимо реализовать класс Main, используя java.util.Scanner, прочесть информацию из текстового представления справочника и разложить данные в модель City с полями:
//name – наименование города
//region – регион
//district – федеральный округ
//population – количество жителей города
//foundation – дата основания или первое упоминание

//Пример полученного результата:
//City{name='Адыгейск', region='Адыгея', district='Южный', population=12248, foundation='1973'}
//City{name='Майкоп', region='Адыгея', district='Южный', population=144246, foundation='1857'}
//City{name='Горно-Алтайск', region='Алтай', district='Сибирский', population=56928, foundation='1830'}

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(
                "D:\\Java\\Задача ВС Java Сбер.csv"));

        String line = null;
        Scanner scanner = null;
        int index = 0;
        ArrayList<City> cities = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            City city = new City();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    city.setId(Integer.parseInt(data));
                else if (index == 1)
                    city.setName(data);
                else if (index == 2)
                    city.setRegion(data);
                else if (index == 3)
                    city.setDistrict(data);
                else if (index == 4)
                    city.setPopulation(Long.parseLong(data));
                else if (index == 5)
                    city.setFoundation(data);
                index++;
            }
            index = 0;
            cities.add(city);
        }
        reader.close();

        System.out.println(cities);
    }
}