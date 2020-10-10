package spring.boot.paginationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TutorialController {

	@Autowired
	private TutorialReposiotry tutorialRepository;

	@GetMapping("/tutorials/page")
	Page<Tutorial> loadTutorialPage(@PageableDefault(page = 1, size = 10) @SortDefault.SortDefaults({
			@SortDefault(sort = "title", direction = Sort.Direction.DESC),
			@SortDefault(sort = "id", direction = Sort.Direction.ASC) }) Pageable pageable) {

		return tutorialRepository.findAll(pageable);
	}

	@GetMapping("/tutorials/slice")
	Slice<Tutorial> loadTutorialSlice(Pageable pageable) {
		return tutorialRepository.findAll(pageable);
	}

}
