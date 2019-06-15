import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Helper {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);

        // Map.Entry - описываем пару (ключ - значение) "3=Среда" и т.п.
        // entrySet - возращает множество со значениями карты, т.е. [3=Среда, 2=Вторник, 1=Понедельник]


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("ID =  " + entry.getKey() + " День недели = " + entry.getValue());
        }

        System.out.println();

        // Iterator - интерфейс, для организации цикла для перебора коллекций
        // hasNext - true, если есть еще элементы
        // next - возвращает слудующий элемент

        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("ID = " + entry.getKey() + " День недели = " + entry.getValue());

            int counter = entry.getValue();
            counter += 1;
        }

        System.out.println();

        // keySet - возвращает множество ключей

        for (String key : map.keySet()) {
            System.out.println("ID = " + key + ", День недели = " +  map.get(key));
        }
        System.out.println();
    }
}
