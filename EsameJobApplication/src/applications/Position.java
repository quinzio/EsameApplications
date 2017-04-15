package applications;

import java.util.*;
import java.util.stream.Collectors;

public class Position {
	private String name;
	private HandleApplications ha;
	private Set<Skill> skillsOfPosition = new HashSet<>();
	private Set<Applicant> candidates = new HashSet<>();

	public Position(String name) {
		this.name = name;
	}

	public void addCandidate(Applicant can) {
		candidates.add(can);
	}

	public void addSkill(Skill sk) {
		skillsOfPosition.add(sk);
	}

	public Set<Skill> getSkills() {
		return skillsOfPosition;
	}

	public String getName() {
		return null;
	}

	public List<String> getApplicants() {
		return candidates.stream().map(Applicant::getName).sorted()
				.collect(Collectors.toList());

	}

	public String getWinner() {
		return null;
	}
}