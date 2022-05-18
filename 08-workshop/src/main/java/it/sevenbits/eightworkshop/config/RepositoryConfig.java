package it.sevenbits.eightworkshop.config;


import it.sevenbits.eightworkshop.core.repository.commentaries.ICommentaryRepository;
import it.sevenbits.eightworkshop.core.repository.commentaries.PostgresCommentaryRepository;
import it.sevenbits.eightworkshop.core.repository.posts.IPostRepository;
import it.sevenbits.eightworkshop.core.repository.posts.PostgresPostRepository;
import it.sevenbits.eightworkshop.core.repository.users.IUserRepository;
import it.sevenbits.eightworkshop.core.repository.users.PostgresUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;

/**
 * Config for repository
 */
@Configuration
public class RepositoryConfig {
    /**
     * Returns user repository
     * @param jdbcOperations - jdbc template
     * @return returns user repository
     */
    @Bean
    public IUserRepository userRepository(final JdbcOperations jdbcOperations) {
        return new PostgresUserRepository(jdbcOperations);
    }

    /**
     * Returns post repository
     * @param jdbcOperations - jdbc template
     * @return returns post repository
     */
    @Bean
    public IPostRepository postRepository(final JdbcOperations jdbcOperations) {
        return new PostgresPostRepository(jdbcOperations);
    }

    /**
     * Returns commentary repository
     * @param jdbcOperations - jdbc template
     * @return returns commentary repository
     */
    @Bean
    public ICommentaryRepository commentaryRepository(final JdbcOperations jdbcOperations) {
        return new PostgresCommentaryRepository(jdbcOperations);
    }
}
