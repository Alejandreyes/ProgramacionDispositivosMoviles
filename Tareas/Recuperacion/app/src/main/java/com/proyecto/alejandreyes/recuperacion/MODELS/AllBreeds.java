package com.proyecto.alejandreyes.recuperacion.MODELS;

import java.util.ArrayList;

public class AllBreeds {
    private String status ;
    private Razas message;
    public static  String[] todasRazas;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Razas getMessage() {
        return message;
    }

    public void setMessage(Razas message) {
        this.message = message;
    }

    public ArrayList<RazasRecycler> transformaObjetoLista() {
        ArrayList<RazasRecycler> razas = new ArrayList<>();
        RazasRecycler razaTemporal = new RazasRecycler();
        razaTemporal.setInformacion("affenpinscher",message.getAffenpinscher());
        razas.add(razaTemporal) ;
        razas.add(new RazasRecycler("african",message.getAfrican()));

        razas.add(new RazasRecycler("airedale",message.getAiredale()));
        razas.add(new RazasRecycler("akita",message.getAkita()));
        razas.add(new RazasRecycler("appenzeller",message.getAffenpinscher()));
        razas.add(new RazasRecycler("basenji",message.getBasenji()));
        razas.add(new RazasRecycler("beagle",message.getBeagle()));
        razas.add(new RazasRecycler("bluetick",message.getBluetick()));
        razas.add(new RazasRecycler("borzoi",message.getBorzoi()));
        razas.add(new RazasRecycler("bouvier",message.getBouvier()));
        razas.add(new RazasRecycler("boxer",message.getBoxer()));
        razas.add(new RazasRecycler("brabancon",message.getBrabancon()));
        razas.add(new RazasRecycler("briard",message.getBriard()));
        razas.add(new RazasRecycler("bulldog",message.getBulldog()));
        razas.add(new RazasRecycler("bullterrier",message.getBullterrier()));

        razas.add(new RazasRecycler("cairn",message.getCairn()));
        razas.add(new RazasRecycler("cattledog",message.getCattledog()));
        razas.add(new RazasRecycler("chihuahua",message.getChihuahua()));
        razas.add(new RazasRecycler("chow",message.getChow()));
        razas.add(new RazasRecycler("clumber",message.getClumber()));
        razas.add(new RazasRecycler("cockapoo",message.getCockapoo()));
        razas.add(new RazasRecycler("collie",message.getCollie()));
        razas.add(new RazasRecycler("coonhound",message.getCoonhound()));
        razas.add(new RazasRecycler("corgi",message.getCorgi()));
        razas.add(new RazasRecycler("cotondetulear",message.getCotondetulear()));
        razas.add(new RazasRecycler("dachshund",message.getDachshund()));
        razas.add(new RazasRecycler("dalmatian",message.getDalmatian()));
        razas.add(new RazasRecycler("dane",message.getDane()));
        razas.add(new RazasRecycler("deerhound",message.getDeerhound()));
        razas.add(new RazasRecycler("dhole",message.getDhole()));
        razas.add(new RazasRecycler("dingo",message.getDingo()));
        razas.add(new RazasRecycler("doberman",message.getDoberman()));
        razas.add(new RazasRecycler("elkhound",message.getElkhound()));
        razas.add(new RazasRecycler("entlebucher",message.getEntlebucher()));
        razas.add(new RazasRecycler("eskimo",message.getEskimo()));
        razas.add(new RazasRecycler("frise",message.getFrise()));
        razas.add(new RazasRecycler("germanshepherd",message.getGermanshepherd()));
        razas.add(new RazasRecycler("greyhound",message.getGreyhound()));
        razas.add(new RazasRecycler("groenendael",message.getGroenendael()));
        razas.add(new RazasRecycler("hound",message.getHound()));
        razas.add(new RazasRecycler("husky",message.getHusky()));
        razas.add(new RazasRecycler("keeshond",message.getKeeshond()));
        razas.add(new RazasRecycler("kelpie",message.getKelpie()));
        razas.add(new RazasRecycler("komondor",message.getKomondor()));
        razas.add(new RazasRecycler("kuvasz",message.getKuvasz()));
        razas.add(new RazasRecycler("labrador",message.getLabrador()));
        razas.add(new RazasRecycler("leonberg",message.getLeonberg()));
        razas.add(new RazasRecycler("lhasa",message.getLhasa()));
        razas.add(new RazasRecycler("malamute",message.getMalamute()));
        razas.add(new RazasRecycler("malinois",message.getMalinois()));
        razas.add(new RazasRecycler("maltese",message.getMaltese()));
        razas.add(new RazasRecycler("mastiff",message.getMastiff()));
        razas.add(new RazasRecycler("mexicanhairless",message.getMexicanhairless()));
        razas.add(new RazasRecycler("mix",message.getMix()));
        razas.add(new RazasRecycler("mountain",message.getMountain()));
        razas.add(new RazasRecycler("newfoundland",message.getNewfoundland()));
        razas.add(new RazasRecycler("otterhound",message.getOtterhound()));
        razas.add(new RazasRecycler("papillon",message.getPapillon()));
        razas.add(new RazasRecycler("pekinese",message.getPekinese()));
        razas.add(new RazasRecycler("pembroke",message.getPembroke()));
        razas.add(new RazasRecycler("pointer",message.getPointer()));
        razas.add(new RazasRecycler("pomeranian",message.getPomeranian()));
        razas.add(new RazasRecycler("poodle",message.getPoodle()));
        razas.add(new RazasRecycler("pug",message.getPug()));
        razas.add(new RazasRecycler("puggle",message.getPuggle()));
        razas.add(new RazasRecycler("pyrenees",message.getPyrenees()));
        razas.add(new RazasRecycler("redbone",message.getRedbone()));
        razas.add(new RazasRecycler("retriever",message.getRetriever()));
        razas.add(new RazasRecycler("redbone",message.getRedbone()));
        razas.add(new RazasRecycler("ridgeback",message.getRidgeback()));
        razas.add(new RazasRecycler("rottweiler",message.getRottweiler()));
        razas.add(new RazasRecycler("saluki",message.getSaluki()));
        razas.add(new RazasRecycler("samoyed",message.getSamoyed()));
        razas.add(new RazasRecycler("schipperke",message.getSchipperke()));
        razas.add(new RazasRecycler("schnauzer",message.getSchnauzer()));
        razas.add(new RazasRecycler("setter",message.getSetter()));
        razas.add(new RazasRecycler("sheepdog",message.getSheepdog()));
        razas.add(new RazasRecycler("shiba",message.getShiba()));
        razas.add(new RazasRecycler("shihtzu",message.getShihtzu()));
        razas.add(new RazasRecycler("spaniel",message.getSpaniel()));
        razas.add(new RazasRecycler("spinger",message.getSpinger()));
        razas.add(new RazasRecycler("stbernard",message.getStbernard()));
        razas.add(new RazasRecycler("terrier",message.getTerrier()));
        razas.add(new RazasRecycler("vizsla",message.getVizsla()));
        razas.add(new RazasRecycler("weimaraner",message.getWeimaraner()));
        razas.add(new RazasRecycler("whippet",message.getWhippet()));
        razas.add(new RazasRecycler("wolfhound",message.getWolfhound()));

        return  razas ;

    }
    public static String[] getAllBreeds(){
        String[] todasRa = {"Selecciona una raza" ,"affenpinscher","cattledog","african","akita","airedale","appenzeller","basenji","beagle","bluetick","borzoi","bouvier","boxer","brabancon","bulldog","briard","bullterrier","cairn","chihuahua","chow","clumber","cockapoo","collie","coonhound","corgi","cotondetulear","dachshund","dalmatian","dane","deerhound","dhole","dingo","doberman","elkhound","entlebucher","eskimo","frise","germanshepherd","greyhound","groenendael","hound","husky","keeshond","kelpie","komondor","kuvasz","labrador","leonberg","lhasa","malamute","malinois","maltese","mastiff","mexicanhairless","mix","mountain","newfoundland","otterhound","papillon","pekinese","pembroke","pinscher","pointer","pomeranian","poodle","pug","puggle","pyrenees","redbone","retriever","ridgeback","rottweiler","saluki","samoyed","schipperke"," schnauzer","setter","sheepdog","shiba","shihtzu","spaniel","spinger","stbernard","terrier","vizsla","weimaraner","whippet","wolfhound"};
        todasRazas = todasRa;
        return todasRazas;
    }

    public class Razas {
        ArrayList<String>  affenpinscher,cattledog;
        ArrayList<String>  african,akita,airedale,appenzeller,basenji,beagle,bluetick,borzoi,bouvier,boxer,brabancon;
        ArrayList<String>  bulldog,briard,bullterrier,cairn,chihuahua,chow,clumber,cockapoo,collie,coonhound;
        ArrayList<String> corgi,cotondetulear,dachshund,dalmatian,dane,deerhound,dhole,dingo,doberman;
        ArrayList<String> elkhound,entlebucher,eskimo,frise,germanshepherd,greyhound,groenendael,hound,husky;
        ArrayList<String> keeshond,kelpie,komondor,kuvasz,labrador,leonberg,lhasa,malamute,malinois,maltese;
        ArrayList<String> mastiff,mexicanhairless,mix,mountain,newfoundland,otterhound,papillon,pekinese,pembroke,pinscher;
        ArrayList<String> pointer,pomeranian,poodle,pug,puggle,pyrenees,redbone,retriever,ridgeback,rottweiler,saluki,samoyed;
        ArrayList<String> schipperke, schnauzer,setter,sheepdog,shiba,shihtzu,spaniel,spinger,stbernard,terrier,vizsla,weimaraner;
        ArrayList<String> whippet,wolfhound;

        public ArrayList<String> getCattledog() {
            return cattledog;
        }

        public void setCattledog(ArrayList<String> cattledog) {
            this.cattledog = cattledog;
        }

        public ArrayList<String> getBasenji() {
            return basenji;
        }

        public ArrayList<String> getAiredale() {
            return airedale;
        }

        public void setAiredale(ArrayList<String> airedale) {
            this.airedale = airedale;
        }

        public void setBasenji(ArrayList<String> basenji) {
            this.basenji = basenji;
        }

        public ArrayList<String> getBeagle() {
            return beagle;
        }

        public void setBeagle(ArrayList<String> beagle) {
            this.beagle = beagle;
        }

        public ArrayList<String> getBluetick() {
            return bluetick;
        }

        public void setBluetick(ArrayList<String> bluetick) {
            this.bluetick = bluetick;
        }

        public ArrayList<String> getBorzoi() {
            return borzoi;
        }

        public void setBorzoi(ArrayList<String> borzoi) {
            this.borzoi = borzoi;
        }

        public ArrayList<String> getBouvier() {
            return bouvier;
        }

        public void setBouvier(ArrayList<String> bouvier) {
            this.bouvier = bouvier;
        }

        public ArrayList<String> getBoxer() {
            return boxer;
        }

        public void setBoxer(ArrayList<String> boxer) {
            this.boxer = boxer;
        }

        public ArrayList<String> getBrabancon() {
            return brabancon;
        }

        public void setBrabancon(ArrayList<String> brabancon) {
            this.brabancon = brabancon;
        }

        public ArrayList<String> getBriard() {
            return briard;
        }

        public void setBriard(ArrayList<String> briard) {
            this.briard = briard;
        }

        public ArrayList<String> getBullterrier() {
            return bullterrier;
        }

        public void setBullterrier(ArrayList<String> bullterrier) {
            this.bullterrier = bullterrier;
        }

        public ArrayList<String> getCairn() {
            return cairn;
        }

        public void setCairn(ArrayList<String> cairn) {
            this.cairn = cairn;
        }

        public ArrayList<String> getChihuahua() {
            return chihuahua;
        }

        public void setChihuahua(ArrayList<String> chihuahua) {
            this.chihuahua = chihuahua;
        }

        public ArrayList<String> getChow() {
            return chow;
        }

        public void setChow(ArrayList<String> chow) {
            this.chow = chow;
        }

        public ArrayList<String> getClumber() {
            return clumber;
        }

        public void setClumber(ArrayList<String> clumber) {
            this.clumber = clumber;
        }

        public ArrayList<String> getCockapoo() {
            return cockapoo;
        }

        public void setCockapoo(ArrayList<String> cockapoo) {
            this.cockapoo = cockapoo;
        }

        public ArrayList<String> getCollie() {
            return collie;
        }

        public void setCollie(ArrayList<String> collie) {
            this.collie = collie;
        }

        public ArrayList<String> getCoonhound() {
            return coonhound;
        }

        public void setCoonhound(ArrayList<String> coonhound) {
            this.coonhound = coonhound;
        }

        public ArrayList<String> getCorgi() {
            return corgi;
        }

        public void setCorgi(ArrayList<String> corgi) {
            this.corgi = corgi;
        }

        public ArrayList<String> getCotondetulear() {
            return cotondetulear;
        }

        public void setCotondetulear(ArrayList<String> cotondetulear) {
            this.cotondetulear = cotondetulear;
        }

        public ArrayList<String> getDachshund() {
            return dachshund;
        }

        public void setDachshund(ArrayList<String> dachshund) {
            this.dachshund = dachshund;
        }

        public ArrayList<String> getDalmatian() {
            return dalmatian;
        }

        public void setDalmatian(ArrayList<String> dalmatian) {
            this.dalmatian = dalmatian;
        }

        public ArrayList<String> getDane() {
            return dane;
        }

        public void setDane(ArrayList<String> dane) {
            this.dane = dane;
        }

        public ArrayList<String> getDeerhound() {
            return deerhound;
        }

        public void setDeerhound(ArrayList<String> deerhound) {
            this.deerhound = deerhound;
        }

        public ArrayList<String> getDhole() {
            return dhole;
        }

        public void setDhole(ArrayList<String> dhole) {
            this.dhole = dhole;
        }

        public ArrayList<String> getDingo() {
            return dingo;
        }

        public void setDingo(ArrayList<String> dingo) {
            this.dingo = dingo;
        }

        public ArrayList<String> getDoberman() {
            return doberman;
        }

        public void setDoberman(ArrayList<String> doberman) {
            this.doberman = doberman;
        }

        public ArrayList<String> getElkhound() {
            return elkhound;
        }

        public void setElkhound(ArrayList<String> elkhound) {
            this.elkhound = elkhound;
        }

        public ArrayList<String> getEntlebucher() {
            return entlebucher;
        }

        public void setEntlebucher(ArrayList<String> entlebucher) {
            this.entlebucher = entlebucher;
        }

        public ArrayList<String> getEskimo() {
            return eskimo;
        }

        public void setEskimo(ArrayList<String> eskimo) {
            this.eskimo = eskimo;
        }

        public ArrayList<String> getFrise() {
            return frise;
        }

        public void setFrise(ArrayList<String> frise) {
            this.frise = frise;
        }

        public ArrayList<String> getGermanshepherd() {
            return germanshepherd;
        }

        public void setGermanshepherd(ArrayList<String> germanshepherd) {
            this.germanshepherd = germanshepherd;
        }

        public ArrayList<String> getGreyhound() {
            return greyhound;
        }

        public void setGreyhound(ArrayList<String> greyhound) {
            this.greyhound = greyhound;
        }

        public ArrayList<String> getGroenendael() {
            return groenendael;
        }

        public void setGroenendael(ArrayList<String> groenendael) {
            this.groenendael = groenendael;
        }

        public ArrayList<String> getHound() {
            return hound;
        }

        public void setHound(ArrayList<String> hound) {
            this.hound = hound;
        }

        public ArrayList<String> getHusky() {
            return husky;
        }

        public void setHusky(ArrayList<String> husky) {
            this.husky = husky;
        }

        public ArrayList<String> getKeeshond() {
            return keeshond;
        }

        public void setKeeshond(ArrayList<String> keeshond) {
            this.keeshond = keeshond;
        }

        public ArrayList<String> getKelpie() {
            return kelpie;
        }

        public void setKelpie(ArrayList<String> kelpie) {
            this.kelpie = kelpie;
        }

        public ArrayList<String> getKomondor() {
            return komondor;
        }

        public void setKomondor(ArrayList<String> komondor) {
            this.komondor = komondor;
        }

        public ArrayList<String> getKuvasz() {
            return kuvasz;
        }

        public void setKuvasz(ArrayList<String> kuvasz) {
            this.kuvasz = kuvasz;
        }

        public ArrayList<String> getLabrador() {
            return labrador;
        }

        public void setLabrador(ArrayList<String> labrador) {
            this.labrador = labrador;
        }

        public ArrayList<String> getLeonberg() {
            return leonberg;
        }

        public void setLeonberg(ArrayList<String> leonberg) {
            this.leonberg = leonberg;
        }

        public ArrayList<String> getLhasa() {
            return lhasa;
        }

        public void setLhasa(ArrayList<String> lhasa) {
            this.lhasa = lhasa;
        }

        public ArrayList<String> getMalamute() {
            return malamute;
        }

        public void setMalamute(ArrayList<String> malamute) {
            this.malamute = malamute;
        }

        public ArrayList<String> getMalinois() {
            return malinois;
        }

        public void setMalinois(ArrayList<String> malinois) {
            this.malinois = malinois;
        }

        public ArrayList<String> getMaltese() {
            return maltese;
        }

        public void setMaltese(ArrayList<String> maltese) {
            this.maltese = maltese;
        }

        public ArrayList<String> getMastiff() {
            return mastiff;
        }

        public void setMastiff(ArrayList<String> mastiff) {
            this.mastiff = mastiff;
        }

        public ArrayList<String> getMexicanhairless() {
            return mexicanhairless;
        }

        public void setMexicanhairless(ArrayList<String> mexicanhairless) {
            this.mexicanhairless = mexicanhairless;
        }

        public ArrayList<String> getMix() {
            return mix;
        }

        public void setMix(ArrayList<String> mix) {
            this.mix = mix;
        }

        public ArrayList<String> getMountain() {
            return mountain;
        }

        public void setMountain(ArrayList<String> mountain) {
            this.mountain = mountain;
        }

        public ArrayList<String> getNewfoundland() {
            return newfoundland;
        }

        public void setNewfoundland(ArrayList<String> newfoundland) {
            this.newfoundland = newfoundland;
        }

        public ArrayList<String> getOtterhound() {
            return otterhound;
        }

        public void setOtterhound(ArrayList<String> otterhound) {
            this.otterhound = otterhound;
        }

        public ArrayList<String> getPapillon() {
            return papillon;
        }

        public void setPapillon(ArrayList<String> papillon) {
            this.papillon = papillon;
        }

        public ArrayList<String> getPekinese() {
            return pekinese;
        }

        public void setPekinese(ArrayList<String> pekinese) {
            this.pekinese = pekinese;
        }

        public ArrayList<String> getPembroke() {
            return pembroke;
        }

        public void setPembroke(ArrayList<String> pembroke) {
            this.pembroke = pembroke;
        }

        public ArrayList<String> getPinscher() {
            return pinscher;
        }

        public void setPinscher(ArrayList<String> pinscher) {
            this.pinscher = pinscher;
        }

        public ArrayList<String> getPointer() {
            return pointer;
        }

        public void setPointer(ArrayList<String> pointer) {
            this.pointer = pointer;
        }

        public ArrayList<String> getPomeranian() {
            return pomeranian;
        }

        public void setPomeranian(ArrayList<String> pomeranian) {
            this.pomeranian = pomeranian;
        }

        public ArrayList<String> getPoodle() {
            return poodle;
        }

        public void setPoodle(ArrayList<String> poodle) {
            this.poodle = poodle;
        }

        public ArrayList<String> getPug() {
            return pug;
        }

        public void setPug(ArrayList<String> pug) {
            this.pug = pug;
        }

        public ArrayList<String> getPuggle() {
            return puggle;
        }

        public void setPuggle(ArrayList<String> puggle) {
            this.puggle = puggle;
        }

        public ArrayList<String> getPyrenees() {
            return pyrenees;
        }

        public void setPyrenees(ArrayList<String> pyrenees) {
            this.pyrenees = pyrenees;
        }

        public ArrayList<String> getRedbone() {
            return redbone;
        }

        public void setRedbone(ArrayList<String> redbone) {
            this.redbone = redbone;
        }

        public ArrayList<String> getRetriever() {
            return retriever;
        }

        public void setRetriever(ArrayList<String> retriever) {
            this.retriever = retriever;
        }

        public ArrayList<String> getRidgeback() {
            return ridgeback;
        }

        public void setRidgeback(ArrayList<String> ridgeback) {
            this.ridgeback = ridgeback;
        }

        public ArrayList<String> getRottweiler() {
            return rottweiler;
        }

        public void setRottweiler(ArrayList<String> rottweiler) {
            this.rottweiler = rottweiler;
        }

        public ArrayList<String> getSaluki() {
            return saluki;
        }

        public void setSaluki(ArrayList<String> saluki) {
            this.saluki = saluki;
        }

        public ArrayList<String> getSamoyed() {
            return samoyed;
        }

        public void setSamoyed(ArrayList<String> samoyed) {
            this.samoyed = samoyed;
        }

        public ArrayList<String> getSchipperke() {
            return schipperke;
        }

        public void setSchipperke(ArrayList<String> schipperke) {
            this.schipperke = schipperke;
        }

        public ArrayList<String> getSchnauzer() {
            return schnauzer;
        }

        public void setSchnauzer(ArrayList<String> schnauzer) {
            this.schnauzer = schnauzer;
        }

        public ArrayList<String> getSetter() {
            return setter;
        }

        public void setSetter(ArrayList<String> setter) {
            this.setter = setter;
        }

        public ArrayList<String> getSheepdog() {
            return sheepdog;
        }

        public void setSheepdog(ArrayList<String> sheepdog) {
            this.sheepdog = sheepdog;
        }

        public ArrayList<String> getShiba() {
            return shiba;
        }

        public void setShiba(ArrayList<String> shiba) {
            this.shiba = shiba;
        }

        public ArrayList<String> getShihtzu() {
            return shihtzu;
        }

        public void setShihtzu(ArrayList<String> shihtzu) {
            this.shihtzu = shihtzu;
        }

        public ArrayList<String> getSpaniel() {
            return spaniel;
        }

        public void setSpaniel(ArrayList<String> spaniel) {
            this.spaniel = spaniel;
        }

        public ArrayList<String> getSpinger() {
            return spinger;
        }

        public void setSpinger(ArrayList<String> spinger) {
            this.spinger = spinger;
        }

        public ArrayList<String> getStbernard() {
            return stbernard;
        }

        public void setStbernard(ArrayList<String> stbernard) {
            this.stbernard = stbernard;
        }

        public ArrayList<String> getTerrier() {
            return terrier;
        }

        public void setTerrier(ArrayList<String> terrier) {
            this.terrier = terrier;
        }

        public ArrayList<String> getVizsla() {
            return vizsla;
        }

        public void setVizsla(ArrayList<String> vizsla) {
            this.vizsla = vizsla;
        }

        public ArrayList<String> getWeimaraner() {
            return weimaraner;
        }

        public void setWeimaraner(ArrayList<String> weimaraner) {
            this.weimaraner = weimaraner;
        }

        public ArrayList<String> getWhippet() {
            return whippet;
        }

        public void setWhippet(ArrayList<String> whippet) {
            this.whippet = whippet;
        }

        public ArrayList<String> getWolfhound() {
            return wolfhound;
        }

        public void setWolfhound(ArrayList<String> wolfhound) {
            this.wolfhound = wolfhound;
        }

        public ArrayList<String> getAppenzeller() {
            return appenzeller;
        }

        public void setAppenzeller(ArrayList<String> appenzeller) {
            this.appenzeller = appenzeller;
        }

        public ArrayList<String> getAkita() {
            return akita;
        }

        public void setAkita(ArrayList<String> akita) {
            this.akita = akita;
        }
        public ArrayList<String> getAfrican() {
            return african;
        }

        public void setAfrican(ArrayList<String> african) {
            this.african = african;
        }

        public ArrayList<String> getBulldog() {
            return bulldog;
        }

        public void setBulldog(ArrayList<String> bulldog) {
            this.bulldog = bulldog;
        }

        public ArrayList<String> getAffenpinscher() {
            return affenpinscher;
        }

        public void setAffenpinscher(ArrayList<String> affenpinscher) {
            this.affenpinscher = affenpinscher;
        }
    }
}
