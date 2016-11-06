package com.hunterdavis.adventureneverstops.utils.story;

import com.hunterdavis.adventureneverstops.ANSApplication;
import com.hunterdavis.adventureneverstops.R;
import com.hunterdavis.adventureneverstops.objects.game.Character;
import com.hunterdavis.adventureneverstops.utils.StringUtils;

/**
 * Created by hunter on 10/31/16.
 */

public class BackStoryUtils extends StringUtils {


    public static String generateBackStory(Character c) {
        return  generateBackstoryTitle(c) + " " +
                generateFamilyLineageBackStory(c) + " " +
                generateSuffixBackStory(c) + " " +
                generateAbilityLineageBackStory(c) + " " +
                generateHomeLandBackStory(c) + " " +
                generateExperienceBackStory(c);
    };

    public static String generateBackstoryTitle(Character c) {
        return ANSApplication.getApplicationResources().getString(R.string.backstory_title_string,c.bio.fullName());
    }

    public static String generateFamilyLineageBackStory(Character c) {
        return ANSApplication.getApplicationResources().getString(R.string.family_backstory_string,c.bio.first, c.bio.last);
    }

    public static String generateAbilityLineageBackStory(Character c) {
        return ANSApplication.getApplicationResources().getString(R.string.family_ability_string,c.bio.first,c.bio.metal, c.bio.last);
    }

    public static String generateHomeLandBackStory(Character c) {
        return ANSApplication.getApplicationResources().getString(R.string.homeland_string,c.bio.first,c.bio.landType, c.bio.last);
    }

    public static String generateSuffixBackStory(Character c) {
        return ANSApplication.getApplicationResources().getString(R.string.suffix_string,c.bio.suffix,c.bio.first);
    }

    public static String generateExperienceBackStory(Character c) {
        return ANSApplication.getApplicationResources().getString(R.string.experience_string,c.experience,c.bio.first);
    }

}
