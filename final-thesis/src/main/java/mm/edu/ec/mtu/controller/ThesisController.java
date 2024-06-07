package mm.edu.ec.mtu.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mm.edu.ec.mtu.model.entity.AcademicYear;
import mm.edu.ec.mtu.model.entity.StudentThesis;
import mm.edu.ec.mtu.model.repo.AcademicYearRepo;
import mm.edu.ec.mtu.model.service.ThesisService;


@Controller
public class ThesisController {
    @Autowired
    private ThesisService thesisService;

    @Autowired
    private AcademicYearRepo academicYearRepository;

    @GetMapping("/theses")
    public String getTheses(ModelMap model, @RequestParam(value = "year", required = false) String year) {
        // Fetch all academic years
        List<String> allYears = academicYearRepository.findAll()
                .stream()
                .map(AcademicYear::getYear)
                .sorted()
                .collect(Collectors.toList());

        // Default to the most recent academic year if no year is provided
        if (year == null) {
            year = allYears.get(allYears.size() - 1);
        }

        // Validate the year
        if (!allYears.contains(year)) {
            throw new RuntimeException("Year not found");
        }

        // Fetch previous and next years
        String previousYear = getPreviousYear(allYears, year);
        String nextYear = getNextYear(allYears, year);

        // Fetch theses for the given year
        List<StudentThesis> theses = thesisService.getThesesByYear(year);
        model.addAttribute("theses", theses);
        model.addAttribute("year", year);
        model.addAttribute("previousYear", previousYear);
        model.addAttribute("nextYear", nextYear);

        return "theses";
    }

    private String getPreviousYear(List<String> allYears, String currentYear) {
        int index = allYears.indexOf(currentYear);
        return (index > 0) ? allYears.get(index - 1) : currentYear;
    }

    private String getNextYear(List<String> allYears, String currentYear) {
        int index = allYears.indexOf(currentYear);
        return (index < allYears.size() - 1) ? allYears.get(index + 1) : currentYear;
    }
}


