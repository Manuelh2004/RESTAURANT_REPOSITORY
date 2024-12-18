package sistema.sistema.Controllers.Branch;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema.sistema.Entities.BranchEntity;
import sistema.sistema.Response.ApiResponse;
import sistema.sistema.Response.ApiResponseBuilder;
import sistema.sistema.Services.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {
    
    @Autowired
    BranchService branchService; 

    @GetMapping
    public ResponseEntity<ApiResponse<List<BranchEntity>>> getAllBranches() {
        List<BranchEntity> branches = branchService.getAllBranches();
        return ApiResponseBuilder.buildResponse(
                HttpStatus.OK,
                "Lista de sucursales obtenida correctamente",
                branches
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BranchEntity>> getBranchById(@PathVariable int id) {
        Optional<BranchEntity> branch = branchService.getBranchById(id);
        return branch.map(b -> ApiResponseBuilder.buildResponse(
                        HttpStatus.OK,
                        "Sucursal obtenida correctamente",
                        b
                ))
                .orElseGet(() -> ApiResponseBuilder.buildResponse(
                        HttpStatus.NOT_FOUND,
                        "Sucursal no encontrada",
                        null
                ));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BranchEntity>> createBranch(@RequestBody BranchEntity branch) {
        BranchEntity savedBranch = branchService.createBranch(branch);
        return ApiResponseBuilder.buildResponse(
                HttpStatus.CREATED,
                "Sucursal creada correctamente",
                savedBranch
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BranchEntity>> updateBranch(@PathVariable int id, @RequestBody BranchEntity branchDetails) {
        try {
            BranchEntity updatedBranch = branchService.updateBranch(id, branchDetails);
            return ApiResponseBuilder.buildResponse(
                    HttpStatus.OK,
                    "Sucursal actualizada correctamente",
                    updatedBranch
            );
        } catch (RuntimeException e) {
            return ApiResponseBuilder.buildResponse(
                    HttpStatus.NOT_FOUND,
                    "Sucursal no encontrada para actualizar",
                    null
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteBranch(@PathVariable int id) {
        branchService.deleteBranch(id);
        return ApiResponseBuilder.buildResponse(
                HttpStatus.NO_CONTENT,
                "Sucursal eliminada correctamente",
                null
        );
    }
}
