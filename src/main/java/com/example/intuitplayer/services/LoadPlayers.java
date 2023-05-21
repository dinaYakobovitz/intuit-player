package com.example.intuitplayer.services;

import com.example.intuitplayer.converters.PlayerConverter;
import com.example.intuitplayer.data.repository.PlayerRepository;
import com.example.intuitplayer.models.PlayerModel;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class LoadPlayers {
    private final PlayerRepository playerRepository;
    @Value("classpath:player.csv")
    private Resource resource;

    @EventListener(ApplicationReadyEvent.class)
    public void load() {
        List<PlayerModel> players = getPlayersFromCsvFile();
        playerRepository.saveAll(players.stream().map(PlayerConverter::toPlayerEntity).collect(toList()));
    }

    public List<PlayerModel> getPlayersFromCsvFile() {
        try {
            Reader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            CsvToBean<PlayerModel> csvToBean = new CsvToBeanBuilder<PlayerModel>(reader).withType(PlayerModel.class).build();
            List<PlayerModel> parse = csvToBean.parse();
            reader.close();
            return parse;
        } catch (Exception e) {
            throw new IllegalArgumentException("Error reading Csv file.");
        }
    }

}
