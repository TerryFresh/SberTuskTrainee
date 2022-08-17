import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


//2.
//Теперь нам нужно реализовать несколько вариантов сортировки данных справочника:
//Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра;
//Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра;
//Затем вывести полученный список объектов City в консоль. При реализации сортировки нужно обратить внимание на возможные варианты реализации: Comparator, lambda-выражения.
//Пример полученного результата для сортировки по наименованию:

//…Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра
//City{name='Абаза', region='Хакасия', district='Сибирский', population=17111, foundation='1867'}
//City{name='Абакан', region='Хакасия', district='Сибирский', population=165183, foundation='1931'}
//City{name='Абдулино', region='Оренбургская область', district='Приволжский', population=20663, foundation='1795'}

//…Сортировка списка городов по федеральному
//Пример полученного результата для сортировки по двум полям справочника – федеральному округу и наименованию города:
//City{name='Алдан', region='Якутия', district='Дальневосточный', population=21277, foundation='1924'}
//City{name='Александровск-Сахалинский', region='Сахалинская область', district='Дальневосточный', population=10613, foundation='1869'}
//City{name='Амурск', region='Хабаровский край', district='Дальневосточный', population=42977, foundation='1958'}

//…Наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра
//City{name='Абдулино', region='Оренбургская область', district='Приволжский', population=20663, foundation='1795'}
//City{name='Агидель', region='Башкортостан', district='Приволжский', population=16365, foundation='1980'}
//City{name='Агрыз', region='Татарстан', district='Приволжский', population=19299, foundation='1646'}

public class Main2 {

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

        sortCityByName(cities);
        sortCityByNameAndDistrict(cities);

    }

    public static void sortCityByName(ArrayList cities) {
        Collections.sort(cities, (Comparator<City>) (o1, o2) -> o1.getName().toLowerCase(Locale.ROOT).compareTo(o2.getName().toLowerCase()));
        for (Object city : cities) {
            System.out.print(city);
        }
    }

    public static void sortCityByNameAndDistrict(ArrayList cities) {
        Collections.sort(cities, (Comparator<City>) (o1, o2) ->
        {
            int secondSort = o1.getDistrict().compareTo(o2.getDistrict());
            if (secondSort != 0)
                return secondSort;
            return o1.getName().compareTo(o2.getName());
        });
        for (Object city : cities) {
            System.out.print(city);
        }
    }
}










