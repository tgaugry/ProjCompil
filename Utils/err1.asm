; entete
.model SMALL
.586
.CODE
debut:
STARTUPCODE

; ouvrePrinc6
mov bp,sp
sub sp,6

push 2
; istore
pop ax
mov word ptr[bp-2],ax

push -1
; istore
pop ax
mov word ptr[bp-6],ax

push 2
; iconst
push word ptr[bp-2]
; imul
pop bx
pop ax
imul bx
push ax

; iconst
push word ptr[bp-6]
; iadd
pop bx
pop ax
add ax,bx
push ax

push 3
; iadd
pop bx
pop ax
add ax,bx
push ax

; istore
pop ax
mov word ptr[bp-4],ax

; queue
nop
exitcode
end debut

