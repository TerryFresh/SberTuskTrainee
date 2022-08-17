import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//Ну что, мы на финишной прямой и нам осталось только реализовать поиск количества городов в разрезе регионов.
//Необходимо определить количество городов в каждом регионе.
//Пример полученного результата:
//Вологодская область - 15
//Татарстан - 22
//Хабаровский край – 7
//…

public class Main4 {
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
        howManyCityInRegion(cities);

    }

    public static void howManyCityInRegion(List<City> cities) {
        HashSet<Object> region = new HashSet<>();
        HashMap<Object, Integer> regionCount = new HashMap<>();

        for (int i = 0; i < cities.size(); i++) {
            if (region.add(cities.get(i).getRegion()))
                regionCount.put(cities.get(i).getRegion(), 1);
            else
                regionCount.put(cities.get(i).getRegion(), regionCount.get(cities.get(i).getRegion()) + 1);
        }

        for (Map.Entry<Object, Integer> entry : regionCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
