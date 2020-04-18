package com.santosh.registration.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.santosh.registration.model.AlbumResponseModel;

@FeignClient("albums-ms")
public interface AlbumFeignClient {
	@GetMapping("/albums/{id}")
	List<AlbumResponseModel> getAlbums(@PathVariable("id") String id);

}
