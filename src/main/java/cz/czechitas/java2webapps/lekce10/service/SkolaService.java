package cz.czechitas.java2webapps.lekce10.service;

import cz.czechitas.java2webapps.lekce10.entity.Rodic;
import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.entity.Ucitel;
import cz.czechitas.java2webapps.lekce10.repository.RodicRepository;
import cz.czechitas.java2webapps.lekce10.repository.StudentRepository;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import cz.czechitas.java2webapps.lekce10.repository.UcitelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkolaService {

    private final RodicRepository rodicRepository;

    private final StudentRepository studentRepository;

    private final TridaRepository tridaRepository;

    private final UcitelRepository ucitelRepository;

    @Autowired
    public SkolaService(RodicRepository rodicRepository, StudentRepository studentRepository, TridaRepository tridaRepository, UcitelRepository ucitelRepository) {
        this.rodicRepository = rodicRepository;
        this.studentRepository = studentRepository;
        this.tridaRepository = tridaRepository;
        this.ucitelRepository = ucitelRepository;
    }

    public List<Trida> findAll() {
        return tridaRepository.findAll();
    }

    public Trida findByNazev(String nazev) {
        return tridaRepository.findByNazev(nazev);
    }

    public List<Student> findStudenti(String nazev){
        return studentRepository.findByTridaNazev(nazev);
    }

    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    public List<Rodic> findRodice(Integer id) {
        return rodicRepository.findRodicByDeti(id);
    }

    public Ucitel findUcitel(String nazev) {
        return ucitelRepository.findByTridaNazev(nazev);
    }
}
