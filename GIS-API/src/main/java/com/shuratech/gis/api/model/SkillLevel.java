package com.shuratech.gis.api.model;

/**
 *
 * @author abbas
 */
public enum SkillLevel {
    Low(30),
    Medium(20), 
    High(10),
    
    ;
    
    
    int level;

    private SkillLevel(int level) {
        this.level = level;
    }
    
    public int getValue(){
        return level;
    }
    public static SkillLevel getByValue(int level){
    	for(SkillLevel x:SkillLevel.values()){
    		if(x.level==level)return x;
    	}
    	return SkillLevel.Low;
    }
    
    
}
