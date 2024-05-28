import java.util.*;

public class Result {
    public static int uniqueWolfs(List<Integer> arr) { // List<Integer>
        // Türlerin kaç kez tespit edildiğini izlemek için bir HashMap kullanıyoruz.
        // Her tür ID'si anahtar olarak, görülme sayısı ise değer olarak saklanır.
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Gözlemler dizisinde dolaşıp her türün görülme sıklığını HashMap'e ekliyoruz.
        for (int id : arr) {
            frequencyMap.put(id, frequencyMap.getOrDefault(id, 0) + 1);
        }

        // En çok görülen türün sayısını ve ID'sini belirliyoruz
        int maxFrequency = 0;
        int minId = Integer.MAX_VALUE;

        // HashMap'deki veriler üzerinden geçerek en yüksek frekansı ve bu frekansa sahip en düşük ID'yi buluyoruz.
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int id = entry.getKey();
            int count = entry.getValue();
            // Yeni maksimum frekans bulduysak veya aynı frekans ama daha küçük bir ID bulduysak güncelliyoruz
            if (count > maxFrequency || (count == maxFrequency && id < minId)) {
                maxFrequency = count;
                minId = id;
            }
        }
        return minId;
    }
}