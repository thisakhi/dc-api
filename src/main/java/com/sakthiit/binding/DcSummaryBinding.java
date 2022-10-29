package com.sakthiit.binding;

import java.util.List;

import lombok.Data;

@Data
public class DcSummaryBinding {

	private DcEducationBinding education;
	private List<DcChildrensBinding> child;
	private DcIncomeBinding income;
	private String planName;
}
