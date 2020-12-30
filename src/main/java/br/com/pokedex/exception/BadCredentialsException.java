package br.com.pokedex.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper=false)
public class BadCredentialsException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private final HttpStatus httpStatusCode;

    private final String code;

    private final String message;

    private final String description;

    public BadCredentialsExceptionBody getOnlyBody() {
        return BadCredentialsExceptionBody.builder()
                .code(this.code)
                .message(this.message)
                .description(this.description)
                .build();
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class BadCredentialsExceptionBody {
        private String code;

        private String message;

        private String description;

    }
}
