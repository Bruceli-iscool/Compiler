	.file	"simple.c"
	.text
	.globl	main
	.type	main, @function
main:
	movl	$0, %eax
	ret
	.size	main, .-main
	.ident	"GCC: (Ubuntu 9.4.0-1ubuntu1~20.04.2) 9.4.0"
	.section	.note.GNU-stack,"",@progbits
