package com.zemikolon.readingcalculator;

public class ReadingMeter {

    public static final int READ_SPEED_SLOW = 100;
    public static final int READ_SPEED_AVERAGE = 130;
    public static final int READ_SPEED_FAST = 160;

    int readSpeed;
    int wordCount;
    String readContent;
    boolean secondsEnable = false;

    public ReadingMeter setSpeed(int speed) {
        readSpeed = speed;
        return this;
    }

    public ReadingMeter setSecondsEnable(boolean enable) {
        secondsEnable = enable;
        return this;
    }

    public ReadingMeter withReadingContent(String content) {
        readContent = content;
        wordCount = getWordCount(content);
        return this;
    }

    public ReadingMeter withWordCount(int count) {
        wordCount = count;
        return this;
    }

    public ReadingMeter withWordCount(long count) {
        wordCount = (int) count;
        return this;
    }

    public static int getWordCount(String content) {
        int count = 0;
        if (null != content && !content.isEmpty()) {
            String[] wordArray = content.trim().split("\\s+");
            count = wordArray.length;
        }
        return count;
    }

    private int getCalculateReadingTime() {
        int milliseconds = 0;
        if (wordCount > -1) {
            float time = (float) wordCount / (float) readSpeed;
            milliseconds = (int)(time * 3600);
        }
        return milliseconds;
    }

    public long inMilliSeconds() {
        return getCalculateReadingTime();
    }

    public String inString() {
        String inString = " ~ min";
        int milliseconds = getCalculateReadingTime();
        if(milliseconds > 0) {
            int seconds = milliseconds / 60;
            int minute = seconds / 60;
            seconds = seconds % 60;
            inString = minute + ":" + String.format("%02d", seconds) + " mins";
            if(!secondsEnable) {
                if (seconds > 30) {
                    inString = minute+1 + ":00" + " mins";
                }
            }
            if (minute == 0 && !secondsEnable) {
                inString = "1:00 min";
                if(seconds <= 30) {
                    inString = "0:30 min";
                }
            }
        }
        return inString;
    }
}