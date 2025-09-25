package ru.practicum.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.practicum.model.comment.Comment;
import ru.practicum.model.comment.DateSort;
import ru.practicum.model.comment.QComment;
import ru.practicum.model.user.User;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, QuerydslPredicateExecutor<Comment> {
    List<Comment> findAllByAuthor(User author);

    interface Predicate {
        static BooleanBuilder textFilter(String text) {
            BooleanBuilder predicate = new BooleanBuilder();
            QComment comment = QComment.comment;

            if (text != null && !text.isBlank()) {
                String searchText = text.trim();
                predicate.and(comment.text.lower().contains(searchText.toLowerCase()));
            }

            return predicate;
        }

        static OrderSpecifier<?> sort(DateSort sort) {
            QComment comment = QComment.comment;
            return (sort == DateSort.DESC) ?
                    comment.created.desc() : comment.created.asc();
        }
    }
}
