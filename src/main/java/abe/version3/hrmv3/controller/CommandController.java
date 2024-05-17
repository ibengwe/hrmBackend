package abe.version3.hrmv3.controller;

import abe.version3.hrmv3.entity.Command;
import abe.version3.hrmv3.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/admin/command")
@RequiredArgsConstructor
public class CommandController {
    private final CommandService service;

    @PostMapping
   public Command saveCommand(@RequestBody Command command){
        return service.createCommand(command);
    }
    @GetMapping
    public List<Command> getAllCommand(){
        return service.findAllCommand();
    }
    @GetMapping("{id}")
    public Optional<Command> findById(@PathVariable Integer id){
        return service.getById(id);
    }
    @DeleteMapping("{id}")
    public void deleteCommand(@PathVariable Integer id){
        service.deleteById(id);
    }
    @PutMapping("{id}")
    public Command updateCommand(@RequestBody Command command,@PathVariable Integer id){
        command.setCommandId(id);
        return service.createCommand(command);
    }


}
