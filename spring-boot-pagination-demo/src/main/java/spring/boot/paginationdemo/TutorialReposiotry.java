package spring.boot.paginationdemo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialReposiotry extends PagingAndSortingRepository<Tutorial, Long> {

	@Query("Select t from Tutorial t")
	Slice<Tutorial> findAllSlice(Pageable pageable);
}
