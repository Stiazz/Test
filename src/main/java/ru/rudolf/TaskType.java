package ru.rudolf;

//bug (ошибка), feature (новая функциональность) и improvement (улучшение существующего кода)

public enum TaskType {
    BUG(0.8f),FEATURE(0.85f), IMPROVEMENT(0.9f),;

    private float k;

    TaskType(float k) {
        this.k = k;
    }

    public float getK() {
        return k;
    }
}
