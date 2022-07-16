package com.godhenko.narutomod.stats;

public interface IData<T> {
    //Chakra//
    void consumeChakra(float points);
    void fillChakra(float points);
    void setChakra(float points);
    float getChakra();

    //Ninjutsu//
    void setNinjutsu(int health);
    int getNinjutsu();

    //Taijutsu//
    void setTaijutsu(int points);
    int getTaijutsu();


    //Genjutsu//
    void setGenjutsu(int points);
    int getGenjutsu();


    //Kenjutsu//
    void setKenjutsu(int points);
    int getKenjutsu();


    //ShurikenJutsu//
    void setShurikenJutsu(int points);
    int getShurikenJutsu();

    //Summoning//
    void setSummoning(int points);
    int getSummoning();

    //Kinjutsu//
    void setKinjutsu(int points);
    int getKinjutsu();

    //Senjutsu//
    void setSenjutsu(int points);
    int getSenjutsu();

    //Medical//
    void setMedical(int points);
    int getMedical();

    //Speed//
    void setSpeed(int points);
    int getSpeed();

    //Intelligence//
    void setIntelligence(int points);
    int getIntelligence();


    //Level//
    void setLevel(int level);
    int getLevel();


    //Exp//
    void setExp(int exp);
    void addExp(int exp);
    void removeExp(int exp);
    int getExp();

    //Skillpoints//
    void setSkillpoints(int sp);
    int getSkillpoints();
}
