import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//4.
//Тут все довольно просто: необходимо преобразовать список городов в массив.
//А затем путем перебора массива найти индекс элемента и значение с наибольшим количеством жителей города.
//Пример полученного результата:
//[489] = 11 514 330

public class Main3 {
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
        maxPopulationCity(cities);
    }

    public static void maxPopulationCity(List<City> cities) {

        Object[] arrayCities = new Object[cities.size()];
        long max = 0;
        int index = 0;
        for (int i = 0; i < arrayCities.length; i++) {
            arrayCities[i] = cities.get(i).getPopulation();
            if (cities.get(i).getPopulation() > max) {
                max = cities.get(i).getPopulation();
                index = i;
            }
        }
        System.out.println("[" + index + "]" + " = " + arrayCities[index]);

    }
}
