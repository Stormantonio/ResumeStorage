/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Integer storageMaxLength = 10000;
    Resume[] storage = new Resume[storageMaxLength];
    private int size = 0;

    void save(Resume r) {
        if (isFull()) {
            System.out.println("Хранилище резюме переполнено!!!");
            return;
        }
        if (find(r.getUuid()) != -1) {
            System.out.println("Извините, такое " + r + " резюме уже есть!!!");
            return;
        }
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        if (isNull())
            return new Resume();
        int findIndex = find(uuid);
        if (findIndex != -1) {
            return storage[findIndex];
        }
        String message = "Такого " + uuid + " резюме нет!!!";
        return new Resume(message);
    }

    void delete(String uuid) {
        if (isNull())
            return;
        int findIndex = find(uuid);
        if (findIndex != -1) {
            storage[findIndex] = storage[size - 1];
            size--;
            return;
        }
        System.out.println("Такого " + uuid + " резюме нет!!!");
    }

    /*@Override
    public void save(Resume r) {
        if (isFull()) {
            System.out.println("Хранилище резюме переполнено!!!");
            return;
        }
        if (find(r.getUuid()) != -1) {
            System.out.println("Извините, такое " + r + " резюме уже есть!!!");
            return;
        }
        storage[size] = r;
        size++;
    }

    @Override
    public void delete(String uuid) {
        if (isNull())
            return;
        int findIndex = find(uuid);
        if (findIndex != -1) {
            storage[findIndex] = storage[size - 1];
            size--;
            return;
        }
        System.out.println("Такого " + uuid + " резюме нет!!!");
    }

    @Override
    public Resume get(String uuid) {
        if (isNull())
            return new Resume();
        int findIndex = find(uuid);
        if (findIndex != -1) {
            return storage[findIndex];
        }
        String message = "Такого " + uuid + " резюме нет!!!";
        return new Resume(message);
    }*/

    private boolean isFull() {
        if (size == storageMaxLength)
            return true;
        else
            return false;
    }

    private int find(String uuidToFound) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuidToFound)) {
                return i;
            }
        }
        return -1;
    }

    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return size;
    }

    private boolean isNull() {
        if (size == 0) {
            System.out.println("Хранилище резюме пустое!!!");
            return true;
        }
        return false;
    }

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }
}
