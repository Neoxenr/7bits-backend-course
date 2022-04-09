package it.sevenbits.eightworkshop.config;

import it.sevenbits.eightworkshop.core.repository.commentaries.ICommentaryRepository;
import it.sevenbits.eightworkshop.core.repository.posts.IPostRepository;
import it.sevenbits.eightworkshop.core.repository.users.IUserRepository;
import it.sevenbits.eightworkshop.web.service.commentaries.CommentaryService;
import it.sevenbits.eightworkshop.web.service.commentaries.ICommentaryService;
import it.sevenbits.eightworkshop.web.service.posts.IPostService;
import it.sevenbits.eightworkshop.web.service.posts.PostService;
import it.sevenbits.eightworkshop.web.service.users.IUserService;
import it.sevenbits.eightworkshop.web.service.users.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config for service
 */
@Configuration
public class ServiceConfig {

    /**
     * Returns post service
     *
     * @param postRepository repository
     * @return returns post service
     */
    @Bean
    public IPostService postService(final IPostRepository postRepository) {
        return new PostService(postRepository);
    }

    /**
     * Returns user service
     *
     * @param userRepository repository
     * @return returns user service
     */
    @Bean
    public IUserService userService(final IUserRepository userRepository) {
        return new UserService(userRepository);
    }

    /**
     * Returns commentary service
     *
     * @param commentaryRepository repository
     * @return returns commentary service
     */
    @Bean
    public ICommentaryService commentaryService(final ICommentaryRepository commentaryRepository) {
        return new CommentaryService(commentaryRepository);
    }
}
