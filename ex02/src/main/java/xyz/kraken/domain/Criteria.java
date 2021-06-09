package xyz.kraken.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


//상속으로 처리해도 됨 SEARCH
public class Criteria {
	private Integer pageNum = 1 ;
	private Integer amount = 10;
	
	private String type;
	private String keyword;
	
	public Criteria(@NonNull int pageNum, @NonNull int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr(){
		return type == null ? new String[]{} : type.split("");
	}
	
	public String getListLink(){
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", pageNum)
				.queryParam("amount", amount)
				.queryParam("type", type)
				.queryParam("keyword", keyword);
		return builder.toUriString();
	}
	public String getListLink2(){
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("amount", amount)
				.queryParam("type", type)
				.queryParam("keyword", keyword);
		return builder.toUriString();
	}
	public String getListLink3(){
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", pageNum)
				.queryParam("type", type)
				.queryParam("keyword", keyword);
		return builder.toUriString();
	}


}
