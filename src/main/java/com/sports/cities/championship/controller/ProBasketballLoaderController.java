package com.sports.cities.championship.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sports.cities.championship.entity.TeamSeason;

@RestController
public class ProBasketballLoaderController {

	@RequestMapping("/probasketball")
	public Map<String, TeamSeason> index() {
		
		Map<String, TeamSeason> retMap = new HashMap<String, TeamSeason>();

		try {
			Document doc = Jsoup.connect("http://www.basketball-reference.com/leagues/NBA_1993_standings.html").get();
			Elements expandedStandings = doc.select("#all_expanded_standings");

			Comment comments = null;

			Iterator<Node> esIterator = expandedStandings.get(0).childNodes().iterator();

			while (esIterator.hasNext()) {
				Node expandedStandingsChild = esIterator.next();
				if (expandedStandingsChild.nodeName().equalsIgnoreCase("#comment")) {
					comments = (Comment) expandedStandingsChild;
				}
			}

			if (comments != null) {

				Document standingsDoc = Jsoup.parse(comments.getData());

				Elements tableRows = standingsDoc.select("td[data-stat=Overall]");

				

				for (Element row : tableRows) {

					TeamSeason ts = new TeamSeason();

					String[] wonloss = row.text().split("-");

					ts.setWins(Integer.parseInt(wonloss[0]));
					ts.setLosses(Integer.parseInt(wonloss[1]));

					Element parent = row.parent();

					Element nameSib = parent.select("[data-stat=team_name]").get(0);
					String anchor = nameSib.select("a").get(0).attr("href");
					String[] hrefSplit = anchor.split("/");
					String key = hrefSplit[2];

					System.out.println("wins, losses, teamkey = " + ts.getWins() + " " + ts.getLosses() + " " + key);

					ts.setSportKey("NBA");
					ts.setTeamKey(key);
					ts.setTies(0);

					retMap.put(key, ts);
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retMap;
	}

}
