package abe.version3.hrmv3.service;

import abe.version3.hrmv3.entity.Command;
import abe.version3.hrmv3.repository.CommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommandService {
    private final CommandRepository repository;
    public Command createCommand(Command command) {
        return repository.save(command);
    }

    public List<Command> findAllCommand() {
        return
                repository.findAll();
    }

    public Optional<Command> getById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
