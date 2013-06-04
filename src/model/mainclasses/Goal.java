package model.mainclasses;

public interface Goal {
/**
 * 
 * @return goalID
 */
int getGoalId();
/**
 * 
 * @return გოლის ავტორი
 */
Player getPlayer();
/**
 * 
 * @return რომელ მატჩში გავიდა გოლი
 */
Match getMatch();
/**
 * 
 * @return საგოლე პასის ავტორი
 */
Player getAssist();
/**
 * 
 * @return იყო თუ არა პენალტი
 */
boolean isPenalty();
/**
 * 
 * @return გავიდა თუ არა გოლი დამატებით დროში
 */
boolean inExtra();
/**
 * 
 * @return იყო თუ არა გოლი გატანილი საკუთარ კარში
 */
boolean isAuto();
/**
 * 
 * @return რომელ ნახევარში გავიდა გოლი
 */
int whichHalf();
/**
 * 
 * @return რიგით მერამდენე გოლია მატჩში
 */
int queNumber();
/**
 * 
 * @return რომელმა გუნდმა გაიტანა გოლი
 */
Team getTeam();
/**
 * 
 * @param scorer 
 */
void setPlayer(Player scorer);
/**
 * 
 * @param რომელ მატჩში გავიდა გოლი
 */
void setMatch(Match mt);
/**
 * 
 * @param  საგოლე პასის ავტორი
 */
void setAssist(Player assist);
/**
 * 
 * @param isPenalty გადავცემთ ბულეანს თრუ თუ პენალტი იყო თუარა ფოლსი :)
 */
void setPenalty(boolean isPenalty);
/**
 * 
 * @param inExtra
 */
void setExtra(boolean inExtra);
/**
 * 
 * @param isAuto
 */
void setAuto(boolean isAuto);
/**
 * 
 * @param tm
 */
void setTeam(Team tm);
}
