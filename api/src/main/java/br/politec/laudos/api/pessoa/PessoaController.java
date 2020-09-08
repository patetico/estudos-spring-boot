package br.politec.laudos.api.pessoa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PessoaController {
    private final PessoaRepository _pessoaRepository;

    public PessoaController(PessoaRepository _pessoaRepository) {
        this._pessoaRepository = _pessoaRepository;
    }

    @GetMapping("/pessoas")
    public List<Pessoa> Get() {
        return _pessoaRepository.findAll();
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<Pessoa> GetById(@PathVariable(name = "id") long id) {
        Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
        return pessoa
            .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/pessoa")
    public Pessoa Post(@RequestBody Pessoa pessoa) {
        return _pessoaRepository.save(pessoa);
    }

    @PutMapping("/pessoa/{id}")
    public ResponseEntity<Pessoa> Put(
        @PathVariable(value = "id") long id,
        @RequestBody Pessoa newPessoa
    ) {
        Optional<Pessoa> oldPessoa = _pessoaRepository.findById(id);
        if (oldPessoa.isPresent()) {
            Pessoa pessoa = oldPessoa.get();
            pessoa.setNome(newPessoa.getNome());
            _pessoaRepository.save(pessoa);
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pessoa/{id}")
    public ResponseEntity<Pessoa> Delete(@PathVariable(name = "id") long id) {
        Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            _pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
