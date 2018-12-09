package com.proyecto.alejandreyes.recuperacion.API;

import com.proyecto.alejandreyes.recuperacion.MODELS.RandomResult.*;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RamdomRazas {

    public interface RandomAkita {
        @GET("api/breed/akita/images/random")
        Call<AkitaResults> getObjectData();
    }

    public interface RandomAppenzeller {
        @GET("api/breed/appenzeller/images/random")
        Call<AppenzellerResults> getObjectData();
    }


    public interface Randombasenji {
        @GET("api/breed/basenji/images/random")
        Call<Resultbasenji> getObjectData();
    }
    public interface Randommastiff {
        @GET("api/breed/mastiff/images/random")
        Call<Resultmastiff> getObjectData();
    }


    public interface Randombeagle {
        @GET("api/breed/beagle/images/random")
        Call<Resultbeagle> getObjectData();
    }

    public interface Randombluetick {
        @GET("api/breed/bluetick/images/random")
        Call<Resultbluetick> getObjectData();
    }

    public interface Randomborzoi {
        @GET("api/breed/borzoi/images/random")
        Call<Resultborzoi> getObjectData();
    }

    public interface Randombouvier {
        @GET("api/breed/bouvier/images/random")
        Call<Resultbouvier> getObjectData();
    }

    public interface Randomboxer {
        @GET("api/breed/boxer/images/random")
        Call<Resultboxer> getObjectData();
    }

    public interface Randombrabancon {
        @GET("api/breed/brabancon/images/random")
        Call<Resultbrabancon> getObjectData();
    }

    public interface Randombriard {
        @GET("api/breed/briard/images/random")
        Call<Resultbriard> getObjectData();
    }

    public interface Randombulldog {
        @GET("api/breed/bulldog/images/random")
        Call<Resultbulldog> getObjectData();
    }

    public interface Randombullterrier {
        @GET("api/breed/bullterrier/images/random")
        Call<Resultbullterrier> getObjectData();
    }

    public interface Randomcairn {
        @GET("api/breed/cairn/images/random")
        Call<Resultcairn> getObjectData();
    }

    public interface Randomcattledog {
        @GET("api/breed/cattledog/images/random")
        Call<Resultcattledog> getObjectData();
    }

    public interface Randomchihuahua {
        @GET("api/breed/chihuahua/images/random")
        Call<Resultchihuahua> getObjectData();
    }

    public interface Randomchow {
        @GET("api/breed/chow/images/random")
        Call<Resultchow> getObjectData();
    }

    public interface Randomclumber {
        @GET("api/breed/clumber/images/random")
        Call<Resultclumber> getObjectData();
    }

    public interface Randomcockapoo {
        @GET("api/breed/cockapoo/images/random")
        Call<Resultcockapoo> getObjectData();
    }

    public interface Randomcollie {
        @GET("api/breed/collie/images/random")
        Call<Resultcollie> getObjectData();
    }

    public interface Randomcoonhound {
        @GET("api/breed/coonhound/images/random")
        Call<Resultcoonhound> getObjectData();
    }

    public interface Randomcorgi {
        @GET("api/breed/corgi/images/random")
        Call<Resultcorgi> getObjectData();
    }

    public interface Randomcotondetulear {
        @GET("api/breed/cotondetulear/images/random")
        Call<Resultcotondetulear> getObjectData();
    }

    public interface Randomdachshund {
        @GET("api/breed/dachshund/images/random")
        Call<Resultdachshund> getObjectData();
    }

    public interface Randomdalmatian {
        @GET("api/breed/dalmatian/images/random")
        Call<Resultdalmatian> getObjectData();
    }

    public interface Randomdane {
        @GET("api/breed/dane/images/random")
        Call<Resultdane> getObjectData();
    }

    public interface Randomdeerhound {
        @GET("api/breed/deerhound/images/random")
        Call<Resultdeerhound> getObjectData();
    }

    public interface Randomdhole {
        @GET("api/breed/dhole/images/random")
        Call<Resultdhole> getObjectData();
    }

    public interface Randomdingo {
        @GET("api/breed/dingo/images/random")
        Call<Resultdingo> getObjectData();
    }

    public interface Randomdoberman {
        @GET("api/breed/doberman/images/random")
        Call<Resultdoberman> getObjectData();
    }

    public interface Randomelkhound {
        @GET("api/breed/elkhound/images/random")
        Call<Resultelkhound> getObjectData();
    }

    public interface Randomentlebucher {
        @GET("api/breed/entlebucher/images/random")
        Call<Resultentlebucher> getObjectData();
    }

    public interface Randomeskimo {
        @GET("api/breed/eskimo/images/random")
        Call<Resulteskimo> getObjectData();
    }

    public interface Randomfrise {
        @GET("api/breed/frise/images/random")
        Call<Resultfrise> getObjectData();
    }

    public interface Randomgermanshepherd {
        @GET("api/breed/germanshepherd/images/random")
        Call<Resultgermanshepherd> getObjectData();
    }

    public interface Randomgreyhound {
        @GET("api/breed/greyhound/images/random")
        Call<Resultgreyhound> getObjectData();
    }

    public interface Randomgroenendael {
        @GET("api/breed/groenendael/images/random")
        Call<Resultgroenendael> getObjectData();
    }

    public interface Randomhound {
        @GET("api/breed/hound/images/random")
        Call<Resulthound> getObjectData();
    }

    public interface Randomhusky {
        @GET("api/breed/husky/images/random")
        Call<Resulthusky> getObjectData();
    }

    public interface Randomkeeshond {
        @GET("api/breed/keeshond/images/random")
        Call<Resultkeeshond> getObjectData();
    }

    public interface Randomkelpie {
        @GET("api/breed/kelpie/images/random")
        Call<Resultkelpie> getObjectData();
    }

    public interface Randomkomondor {
        @GET("api/breed/komondor/images/random")
        Call<Resultkomondor> getObjectData();
    }

    public interface Randomkuvasz {
        @GET("api/breed/kuvasz/images/random")
        Call<Resultkuvasz> getObjectData();
    }

    public interface Randomlabrador {
        @GET("api/breed/labrador/images/random")
        Call<Resultlabrador> getObjectData();
    }

    public interface Randomleonberg {
        @GET("api/breed/leonberg/images/random")
        Call<Resultleonberg> getObjectData();
    }

    public interface Randomlhasa {
        @GET("api/breed/lhasa/images/random")
        Call<Resultlhasa> getObjectData();
    }

    public interface Randommalamute {
        @GET("api/breed/malamute/images/random")
        Call<Resultmalamute> getObjectData();
    }

    public interface Randommalinois {
        @GET("api/breed/malinois/images/random")
        Call<Resultmalinois> getObjectData();
    }

    public interface Randommaltese {
        @GET("api/breed/maltese/images/random")
        Call<Resultmaltese> getObjectData();
    }

    public interface Randommexicanhairless {
        @GET("api/breed/mexicanhairless/images/random")
        Call<Resultmexicanhairless> getObjectData();
    }

    public interface Randommix {
        @GET("api/breed/mix/images/random")
        Call<Resultmix> getObjectData();
    }

    public interface Randommountain {
        @GET("api/breed/mountain/images/random")
        Call<Resultmountain> getObjectData();
    }

    public interface Randomnewfoundland {
        @GET("api/breed/newfoundland/images/random")
        Call<Resultnewfoundland> getObjectData();
    }

    public interface Randomotterhound {
        @GET("api/breed/otterhound/images/random")
        Call<Resultotterhound> getObjectData();
    }

    public interface Randompapillon {
        @GET("api/breed/papillon/images/random")
        Call<Resultpapillon> getObjectData();
    }

    public interface Randompekinese {
        @GET("api/breed/pekinese/images/random")
        Call<Resultpekinese> getObjectData();
    }

    public interface Randompembroke {
        @GET("api/breed/pembroke/images/random")
        Call<Resultpembroke> getObjectData();
    }

    public interface Randompinscher {
        @GET("api/breed/pinscher/images/random")
        Call<Resultpinscher> getObjectData();
    }

    public interface Randompointer {
        @GET("api/breed/pointer/images/random")
        Call<Resultpointer> getObjectData();
    }

    public interface Randompomeranian {
        @GET("api/breed/pomeranian/images/random")
        Call<Resultpomeranian> getObjectData();
    }

    public interface Randompoodle {
        @GET("api/breed/poodle/images/random")
        Call<Resultpoodle> getObjectData();
    }

    public interface Randompug {
        @GET("api/breed/pug/images/random")
        Call<Resultpug> getObjectData();
    }

    public interface Randompuggle {
        @GET("api/breed/puggle/images/random")
        Call<Resultpuggle> getObjectData();
    }

    public interface Randompyrenees {
        @GET("api/breed/pyrenees/images/random")
        Call<Resultpyrenees> getObjectData();
    }

    public interface Randomredbone {
        @GET("api/breed/redbone/images/random")
        Call<Resultredbone> getObjectData();
    }

    public interface Randomretriever {
        @GET("api/breed/retriever/images/random")
        Call<Resultretriever> getObjectData();
    }

    public interface Randomridgeback {
        @GET("api/breed/ridgeback/images/random")
        Call<Resultridgeback> getObjectData();
    }

    public interface Randomrottweiler {
        @GET("api/breed/rottweiler/images/random")
        Call<Resultrottweiler> getObjectData();
    }

    public interface Randomsaluki {
        @GET("api/breed/saluki/images/random")
        Call<Resultsaluki> getObjectData();
    }

    public interface Randomsamoyed {
        @GET("api/breed/samoyed/images/random")
        Call<Resultsamoyed> getObjectData();
    }

    public interface Randomschipperke {
        @GET("api/breed/schipperke/images/random")
        Call<Resultschipperke> getObjectData();
    }

    public interface Randomschnauzer {
        @GET("api/breed/schnauzer/images/random")
        Call<Resultschnauzer> getObjectData();
    }

    public interface Randomsetter {
        @GET("api/breed/setter/images/random")
        Call<Resultsetter> getObjectData();
    }

    public interface Randomsheepdog {
        @GET("api/breed/sheepdog/images/random")
        Call<Resultsheepdog> getObjectData();
    }

    public interface Randomshiba {
        @GET("api/breed/shiba/images/random")
        Call<Resultshiba> getObjectData();
    }

    public interface Randomshihtzu {
        @GET("api/breed/shihtzu/images/random")
        Call<Resultshihtzu> getObjectData();
    }

    public interface Randomspaniel {
        @GET("api/breed/spaniel/images/random")
        Call<Resultspaniel> getObjectData();
    }

    public interface Randomspringer {
        @GET("api/breed/springer/images/random")
        Call<Resultspringer> getObjectData();
    }

    public interface Randomstbernard {
        @GET("api/breed/stbernard/images/random")
        Call<Resultstbernard> getObjectData();
    }

    public interface Randomterrier {
        @GET("api/breed/terrier/images/random")
        Call<Resultterrier> getObjectData();
    }

    public interface Randomvizsla {
        @GET("api/breed/vizsla/images/random")
        Call<Resultvizsla> getObjectData();
    }

    public interface Randomweimaraner {
        @GET("api/breed/weimaraner/images/random")
        Call<Resultweimaraner> getObjectData();
    }

    public interface Randomwhippet {
        @GET("api/breed/whippet/images/random")
        Call<Resultwhippet> getObjectData();
    }

    public interface Randomwolfhound {
        @GET("api/breed/wolfhound/images/random")
        Call<Resultwolfhound> getObjectData();
    }

}
