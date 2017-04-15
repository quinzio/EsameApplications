package applications;

import java.util.ArrayList;
import java.util.List;

public class Applicant {
	
	private String name;
	private boolean isYetCandidate= false;
	
	public boolean isYetCandidate() {
		return isYetCandidate;
	}

	public void setYetCandidate(boolean isYetCandidate) {
		this.isYetCandidate = isYetCandidate;
	}

	public String getName() {
		return name;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public List<Integer> getLevels() {
		return levels;
	}

	private List<Skill> skills = new ArrayList<>();
	private List<Integer> levels = new ArrayList<>();
	public Applicant(String name) {
		super();
		this.name = name;
	}
	
	public void addSkillLevel(Skill skill, int level){
		skills.add(skill);
		levels.add(new Integer(level));
	}
}
