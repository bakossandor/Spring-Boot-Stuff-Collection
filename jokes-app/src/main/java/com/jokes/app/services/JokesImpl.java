package com.jokes.app.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokesImpl implements Jokes {

    private final ChuckNorrisQuotes quotes;

    @Override
    public String getRandomJoke() {
        return quotes.getRandomQuote();
    }

    public JokesImpl() {
        this.quotes = new ChuckNorrisQuotes();
    }
}
