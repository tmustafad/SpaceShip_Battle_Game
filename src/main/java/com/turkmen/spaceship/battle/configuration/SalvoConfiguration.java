package com.turkmen.spaceship.battle.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by turkmenmustafademirci on 11/20/19.
 */
@Configuration
public class SalvoConfiguration {


    @Value("${app.salvo.zero}")
    public String zero;

    @Value("${app.salvo.one}")
    public String one;

    @Value("${app.salvo.two}")
    public String two;

    @Value("${app.salvo.three}")
    public String three;

    @Value("${app.salvo.four}")
    public String four;

    @Value("${app.salvo.five}")
    public String five;

    @Value("${app.salvo.six}")
    public String six;

    @Value("${app.salvo.seven}")
    public String seven;

    @Value("${app.salvo.eight}")
    public String eight;

    @Value("${app.salvo.nine}")
    public String nine;

    @Value("${app.salvo.A}")
    public String a;

    @Value("${app.salvo.B}")
    public String b;

    @Value("${app.salvo.C}")
    public String c;

    @Value("${app.salvo.D}")
    public String d;

    @Value("${app.salvo.E}")
    public String e;

    @Value("${app.salvo.F}")
    public String f;




}
