package com.hugodev.magalums.config;

import com.hugodev.magalums.entity.Channel;
import com.hugodev.magalums.entity.Status;
import com.hugodev.magalums.repository.ChannelRepository;
import com.hugodev.magalums.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    StatusRepository statusRepository;

    @Override
    public void run(String... args) throws Exception {

        Arrays.stream(Channel.Values.values()).map(c -> c.toChannel()).forEach(c -> channelRepository.save(c));

        Arrays.stream(Status.Values.values()).map(s -> s.toStatus()).forEach(s -> statusRepository.save(s));

    }
}
