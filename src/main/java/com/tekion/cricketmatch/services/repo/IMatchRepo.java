package com.tekion.cricketmatch.services.repo;

import com.tekion.cricketmatch.services.beans.match.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatchRepo extends JpaRepository<Matches, Integer> {}
