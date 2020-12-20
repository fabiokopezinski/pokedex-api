package br.com.pokedex.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class Converter <D,S>{

	
	private ModelMapper conversor;

	public List<S> toArray (List<D> sourceList,Class<S> destClass) {

		return sourceList.stream().map(entity -> conversor.map(entity, destClass)).collect(Collectors.toList());
	}
	
	public Page<S> toPage (Page<D> page,Class<S> destClass) {
		List<S> list = page.stream().map(entity -> conversor.map(entity, destClass)).collect(Collectors.toList());
		return new PageImpl<S>(list);
	}

	public S toEntity(D sourceClass, Class<S> destClass) {
		return conversor.map(sourceClass, destClass);
	}

	public S toOutPut(D sourceClass, Class<S> destClass) {
		return conversor.map(sourceClass, destClass);
	}
}
