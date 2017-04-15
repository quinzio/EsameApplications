package applications;

import java.util.*;

public class Skill {
	private String name;
	private HandleApplications ha;

	public void setHa(HandleApplications ha) {
		this.ha = ha;
	}

	public Skill(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Position> getPositions() {

		List<Position> lp = new ArrayList<>();
		for (Position po : ha.positionsSet) {
			if (po.getSkills().contains(this))
				lp.add(po);
		}
		lp.sort(Comparator.comparing(Position::getName));
		return lp;
	}
}