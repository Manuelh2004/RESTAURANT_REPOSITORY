package sistema.sistema.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.sistema.Entities.BranchEntity;
import sistema.sistema.Repositories.BranchRepository;
import sistema.sistema.Repositories.DepartamentRepository;
import sistema.sistema.Repositories.DistrictRespository;
import sistema.sistema.Repositories.ProvinceRepository;

@Service
public class BranchService {
    @Autowired
    BranchRepository branchRepository;
    @Autowired
    DepartamentRepository departamentRepository;
    @Autowired
    ProvinceRepository provinceRepository;
    @Autowired
    DistrictRespository districtRespository;    
   
    public List<BranchEntity> getAllBranches() {
        return branchRepository.findAll();
    }

    public Optional<BranchEntity> getBranchById(int id) {
        return branchRepository.findById(id);
    }

    public BranchEntity createBranch(BranchEntity branch) {
        return branchRepository.save(branch);
    }

    public BranchEntity updateBranch(int id, BranchEntity branchDetails) {
        return branchRepository.findById(id).map(branch -> {
            branch.setBrh_ruc(branchDetails.getBrh_ruc());
            branch.setBrh_direction(branchDetails.getBrh_direction());
            branch.setBrh_start_date(branchDetails.getBrh_start_date());
            branch.setBrh_end_date(branchDetails.getBrh_end_date());
            branch.setBrh_phone(branchDetails.getBrh_phone());
            branch.setBrh_status(branchDetails.getBrh_status());
            branch.setBrh_capacity(branchDetails.getBrh_capacity());
            branch.setDistrict(branchDetails.getDistrict());
            return branchRepository.save(branch);
        }).orElseThrow(() -> new RuntimeException("Branch not found with id " + id));
    }

    public void deleteBranch(int id) {
        branchRepository.deleteById(id);
    }
}
